package Game;

import GameObjects.FallingObjects.FallingObject;
import GameObjects.FallingObjects.FallingObjectType;
import GameObjects.PlayerObjects.PlayerObject;
import Player.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class CollisionDetector {

    public static void checkCollisions(Player player, List<FallingObject> fallingObjects) {

        runObjectCheck(player.getHoop(), FallingObjectType.BASKETBALL, fallingObjects, player);
        runObjectCheck(player.getGlove(), FallingObjectType.BASEBALL, fallingObjects, player);

    }

    private static void runObjectCheck(PlayerObject playerObject, FallingObjectType correctObjectType, List<FallingObject> fallingObjects, Player player) {
        for (FallingObject fallingObject : fallingObjects) {
            if (isColliding(playerObject, fallingObject)) {
                if (fallingObject.getObjectType() == correctObjectType) {

                    player.addScore(50);
                    player.getHud().appearNice();

                } else {

                    player.reduceLives();
                    player.getHud().appearYikes();

                }

                fallingObject.setGarbage();
            }
        }
    }

    private static boolean isColliding(PlayerObject playerObject, FallingObject fallingObject) {
        if (fallingObject.getX() + fallingObject.getSize() >= playerObject.getX() && // X collides
            fallingObject.getX() <= playerObject.getX() + playerObject.getSize() &&  //
            fallingObject.getY() + fallingObject.getSize() >= playerObject.getY() && // Y collides
            fallingObject.getY() <= playerObject.getY() + playerObject.getSize())    //
        {
            return true;
        }

        return false;
    }

    private static boolean isSwish(PlayerObject playerObject, FallingObject fallingObject) {

        return false;
    }
}
