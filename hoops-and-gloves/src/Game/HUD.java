package Game;

import Player.Player;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class HUD {

    private Player player;
    private Text lives;
    private Text score;


    public HUD(Player player) {
        this.player = player;
        lives = new Text(20, 20, "Lives: " + player.getLives(), "Default", 0, 50);
        score = new Text(650, 20, "Score: " + player.getScore(), "Default", 0, 35);
    }

    public void draw() {
        lives.draw();
        score.draw();
    }

    public void updateLives() {
        lives.setText("Lives: " + player.getLives());
    }

    public void updateScore() {
        score.setText("Score: " + player.getScore());
    }

    public void loseScreen() {

        Text cringe =  new Text(175, 300, "CRINGE", "Default", 1, 150);

        for (int i = 0; i < 3; i++) {

            try {
                cringe.draw();

                Thread.sleep(500);

                cringe.delete();

                Thread.sleep(500);

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }



}
