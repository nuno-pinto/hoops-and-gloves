package Player;

import Court.Court;
import Game.HUD;
import GameObjects.PlayerObjects.Glove;
import GameObjects.PlayerObjects.Hoop;

public class Player {

    private Hoop hoop;
    private Glove glove;
    private final int INITIAL_LIVES = 1000;
    private int lives;
    private int score;
    private boolean isAlive =true;
    private HUD hud;


    public Player(Court court) {
        hoop = new Hoop(court);
        glove = new Glove(court);
    }

    public void init() {
        lives = INITIAL_LIVES;
        score = 0;
        isAlive = true;
        hud.updateLives();
        hud.updateScore();
        resetPosition();
    }

    public void resetPosition() {
        hoop.resetPosition();
        glove.resetPosition();
    }

    public void move() {
        hoop.move();
        glove.move();
    }

    public void reduceLives() {
        lives--;

        hud.updateLives();

        if (lives <= 0)
            isAlive = false;
    }

    public void addScore(int points) {
        score += points;

        hud.updateScore();
    }

    public void setHud(HUD hud) {
        this.hud = hud;
    }

    public HUD getHud() {
        return this.hud;
    }

    public Hoop getHoop() {
        return hoop;
    }

    public Glove getGlove() {
        return glove;
    }

    public int getLives() {
        return lives;
    }
    public int getScore() {
        return score;
    }
    public boolean isAlive(){
        return isAlive;
    }

}
