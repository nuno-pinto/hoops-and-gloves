package GameObjects.FallingObjects;

import Court.Court;

public class Baseball extends FallingObject {
    public static int baseBallSize = 3;
    public Baseball(Court court, int x, int y) {
        super(court, x, y, baseBallSize, "resources/FallingObjects/baseball.png", FallingObjectType.BASEBALL);
    }
}
