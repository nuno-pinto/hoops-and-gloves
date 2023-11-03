package Court;

public class Position {

    private int x;
    private int y;
    private final int CELL_SIZE = 15;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position copyPosition() {
       return new Position(x, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getPixelX() {
        return this.x * CELL_SIZE;
    }

    public int getPixelY() {
        return this.y * CELL_SIZE;
    }

    public int getCellSize() {
        return this.CELL_SIZE;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }
}
