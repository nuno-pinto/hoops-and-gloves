package Game;

import Court.Court;
import GameObjects.FallingObjects.FallingObject;
import GameObjects.FallingObjects.FallingObjectFactory;
import Player.Controls;
import Player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Game {

    private Court court;
    private volatile Player player;
    private HUD hud;
    private List<FallingObject> fallingObjects;

    public Game() {

        court = new Court();
        court.draw();

        fallingObjects = Collections.synchronizedList(new ArrayList<>());
        //fallingObjects = new CopyOnWriteArrayList<>();

        player = new Player(court);
        hud = new HUD(player);

        player.setHud(hud);

        new Controls(player);
    }
    public void init() {
        player.init();
        hud.draw();
        clearFallingObjects();
    }

    public void start() {
        while (true) {
            init();
            play();
            hud.loseScreen();
            FallingObjectFactory.resetFactory();
        }
    }

    public void play() {

        while(player.isAlive()) {
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                System.out.println(e);
            }

            CollisionDetector.checkCollisions(player, fallingObjects);

            deleteGarbage();

            FallingObjectFactory.createFallingObject(court, fallingObjects);

            updateMovement();

        }
    }



    private void updateMovement() {

        for (FallingObject obj : fallingObjects) {
            obj.moveDown();
        }

        player.move();

    }


    private void clearFallingObjects() {

        if (!fallingObjects.isEmpty()) {

            for (FallingObject obj : fallingObjects) {
                obj.setGarbage();
            }
        }

        deleteGarbage();
    }

    private void deleteGarbage() {

        for (FallingObject obj : fallingObjects) {
            if (obj.isGarbage()) {
                fallingObjects.remove(obj);
                obj.delete();
                return;
            }
        }

    }

}
