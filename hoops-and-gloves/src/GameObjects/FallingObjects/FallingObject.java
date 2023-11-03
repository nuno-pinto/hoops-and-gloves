package GameObjects.FallingObjects;

import Court.Court;
import GameObjects.GameObject;

public abstract class FallingObject extends GameObject {

    private int moveCounter = 0;
    private int moveDelay = 3;
    private FallingObjectType objectType;
    private boolean isGarbage = false;

    public FallingObject(Court court, int x, int y, int size, String picture, FallingObjectType objectType) {
        super(court, x, y, size, picture);
        this.objectType = objectType;
    }

    public void moveDown() {

        if (isGarbage) {
            return;
        }

        checkIfOOB();

        if (moveCounter < moveDelay) {
            moveCounter++;
            return;
        }

        moveCounter = 0;
        position.moveDown();
        picture.translate(0, court.getCellSize());

    }

    private void checkIfOOB() {
        if (position.getY() + size >= court.getRows()) {
            isGarbage = true;
            delete();
        }
    }


    public void delete() {
        picture.delete();
    }

    public void setGarbage() {
        isGarbage = true;
        delete();
    }

    public boolean isGarbage() {
        return isGarbage;
    }

    public FallingObjectType getObjectType() {
        return objectType;
    }
}
