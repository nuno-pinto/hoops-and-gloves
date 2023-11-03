package GameObjects.FallingObjects;

import Court.Court;

public class Basketball extends FallingObject {
    public static int basketBallSize = 5;
    public Basketball(Court court, int x, int y) {
        super(court, x, y, basketBallSize, "resources/FallingObjects/basketball.png", FallingObjectType.BASKETBALL);
    }
}
