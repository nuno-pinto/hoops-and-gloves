package Game;

import Player.Player;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HUD {

    private Player player;
    private Text lives;
    private Text score;
    private Picture nice;
    private Picture yikes;
    private ExecutorService niceExecutor;
    private ExecutorService yikesExecutor;


    public HUD(Player player) {
        this.player = player;
        lives = new Text(20, 20, "Lives: " + player.getLives(), "Default", 0, 50);
        score = new Text(650, 20, "Score: " + player.getScore(), "Default", 0, 35);
        nice = new Picture(600, 20, "resources/HUD/nice.png");
        yikes = new Picture(80, 20, "resources/HUD/yikes.png");
        niceExecutor = Executors.newSingleThreadExecutor();
        yikesExecutor = Executors.newSingleThreadExecutor();
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


    // ?????????????????????????????????????
    public void appearNice() {
        //cachedPool.submit(appearAndDisappear(nice, 1000));
        //new Thread(appearAndDisappear(nice, 1000)).start();
        //niceExecutor.submit(appearAndDisappear(nice, 1000));
    }

    // ?????????????????????????????????????
    public void appearYikes() {
        //cachedPool.submit(appearAndDisappear(yikes, 1000));
        //new Thread(appearAndDisappear(yikes, 1000)).start();
        //yikesExecutor.submit(appearAndDisappear(yikes, 1000));
    }

    private Runnable appearAndDisappear(Picture picture, int timeInMs) {

        return () -> {
            picture.draw();

            try {
                Thread.sleep(timeInMs);
            } catch (Exception e) {
                System.out.println(e);
            }

            picture.delete();
        };

    }



}
