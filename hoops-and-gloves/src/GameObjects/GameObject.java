package GameObjects;

import Court.Court;
import Court.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    protected Court court;
    protected Position position;
    protected Picture picture;
    protected int size;

    public GameObject(Court court, int x, int y, int size, String picture) {
        this.court = court;
        this.position = new Position(x, y);
        this.size = size;
        this.picture = new Picture(10 + position.getPixelX(), 10 + position.getPixelY(), picture);
        this.picture.draw();
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public int getSize() {
        return size;
    }

}
