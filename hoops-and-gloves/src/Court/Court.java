package Court;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Court {

    private Picture picture;
    private final int CELL_SIZE = 15;
    private int cols;
    private int rows;

    public Court() {
        picture = new Picture(10, 10, "resources/court.jpg");
        cols = picture.getWidth() / CELL_SIZE;
        rows = picture.getHeight() / CELL_SIZE;
    }

    public void draw() {
        picture.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

}
