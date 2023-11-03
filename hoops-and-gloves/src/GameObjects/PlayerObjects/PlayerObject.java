package GameObjects.PlayerObjects;

import Court.Court;
import Court.Position;
import GameObjects.GameObject;

public abstract class PlayerObject extends GameObject {

    private boolean isMoving = false;
    private boolean movingRight = false;
    private int initialX;
    private Position initialPosition;

    public PlayerObject(Court court, int x, int y, int size, String picture) {
        super(court, x, y, size, picture);
        initialX = this.picture.getX();
        initialPosition = position.copyPosition();
    }

    public void resetPosition() {
        picture.translate(initialX - picture.getX(), 0);
        position = initialPosition.copyPosition();
    }

    public void moveLeft() {

        if (getX() <= 0) {
            return;
        }

        position.moveLeft();
        picture.translate(-court.getCellSize(), 0);
    }

    public void moveRight() {

        if (getX() + size >= court.getCols()) {
            return;
        }

        position.moveRight();
        picture.translate(court.getCellSize(), 0);

    }

    public void move() {
        if (isMoving) {
            if (movingRight) {
                moveRight();
            } else {
                moveLeft();
            }
        }
    }

    public void setMoving(boolean bool) {
        isMoving = bool;
    }

    public void setMovingRight() {
        movingRight = true;
    }

    public void setMovingLeft() {
        movingRight = false;
    }

}
