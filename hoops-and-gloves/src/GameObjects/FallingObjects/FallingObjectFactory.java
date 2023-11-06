package GameObjects.FallingObjects;

import Court.Court;
import GameObjects.FallingObjects.Baseball;
import GameObjects.FallingObjects.Basketball;
import GameObjects.FallingObjects.FallingObject;
import GameObjects.FallingObjects.Trash;

import java.util.ArrayList;
import java.util.List;

public final class FallingObjectFactory {

    private static int createCounter = 0;
    private static int createDelay = 35;
    private static int objectCounter = 1;

    public static void createFallingObject(Court court, List<FallingObject> fallingObjects) {

        if (createCounter < createDelay) {
            createCounter++;
            return;
        }

        createCounter = 0;

        int xPosition;

        double rand = Math.random();

        if (rand < 0.4) {

            xPosition = (int) (Math.random() * (court.getCols() - Basketball.basketBallSize));
            fallingObjects.add(new Basketball(court, xPosition, 0));

        } else if (rand < 0.8){

            xPosition = (int) (Math.random() * (court.getCols() - Baseball.baseBallSize));
            fallingObjects.add(new Baseball(court, xPosition, 0));

        } else {

            xPosition = (int) (Math.random() * (court.getCols() - Trash.trashSize));

            String path = (rand < 0.9) ? "resources/FallingObjects/apple.png" : "resources/FallingObjects/banana.png";

            fallingObjects.add(new Trash(court, xPosition, 0, path));

        }

        objectCounter++;

        if (objectCounter % 15 == 0) {
            createDelay-= 2;
        }

    }

    public static void resetFactory() {
        createDelay = 35;
        createCounter = 0;
        objectCounter = 1;
    }

    public static void reduceDelay(int delayReduceAmount) {

        if (createDelay <= 0) {
            return;
        }

        createDelay -= delayReduceAmount;
    }

}
