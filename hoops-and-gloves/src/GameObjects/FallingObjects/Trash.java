package GameObjects.FallingObjects;

import Court.Court;

public class Trash extends FallingObject{
    public static int trashSize = 2;
    public Trash(Court court, int x, int y, String filePath) {
        super(court, x, y, trashSize, filePath, FallingObjectType.TRASH);
    }
}
