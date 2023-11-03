package Player;

import GameObjects.PlayerObjects.Glove;
import GameObjects.PlayerObjects.Hoop;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    private Hoop hoop;
    private Glove glove;


    public Controls(Player player) {
        hoop = player.getHoop();
        glove = player.getGlove();
        init();
    }

    private void init() {
        Keyboard keyboard = new Keyboard(this);


        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent releasedLeft = new KeyboardEvent();
        releasedLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent releasedRight = new KeyboardEvent();
        releasedRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent pressedA = new KeyboardEvent();
        pressedA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedA.setKey(KeyboardEvent.KEY_A);

        KeyboardEvent releasedA = new KeyboardEvent();
        releasedA.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedA.setKey(KeyboardEvent.KEY_A);

        KeyboardEvent pressedD = new KeyboardEvent();
        pressedD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedD.setKey(KeyboardEvent.KEY_D);

        KeyboardEvent releasedD = new KeyboardEvent();
        releasedD.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releasedD.setKey(KeyboardEvent.KEY_D);

        KeyboardEvent pressedQ = new KeyboardEvent();
        pressedQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedQ.setKey(KeyboardEvent.KEY_Q);



        keyboard.addEventListener(pressedLeft);
        keyboard.addEventListener(releasedLeft);
        keyboard.addEventListener(pressedRight);
        keyboard.addEventListener(releasedRight);
        keyboard.addEventListener(pressedA);
        keyboard.addEventListener(releasedA);
        keyboard.addEventListener(pressedD);
        keyboard.addEventListener(releasedD);
        keyboard.addEventListener(pressedQ);

    }



    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                hoop.setMoving(true);
                hoop.setMovingLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                hoop.setMoving(true);
                hoop.setMovingRight();
                break;
            case KeyboardEvent.KEY_A:
                glove.setMoving(true);
                glove.setMovingLeft();
                break;
            case KeyboardEvent.KEY_D:
                glove.setMoving(true);
                glove.setMovingRight();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                hoop.setMoving(false);
                break;
            case KeyboardEvent.KEY_RIGHT:
                hoop.setMoving(false);
                break;
            case KeyboardEvent.KEY_A:
                glove.setMoving(false);
                break;
            case KeyboardEvent.KEY_D:
                glove.setMoving(false);
                break;
        }
    }
}
