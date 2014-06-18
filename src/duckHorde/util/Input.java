package duckHorde.util;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class Input implements KeyListener {

    public Input(Component comp) {
        comp.addKeyListener(this);
        initKeys();
    }

    private void initKeys() {
        down 		=	new Key(new int[] {KeyEvent.VK_DOWN, KeyEvent.VK_S});
        up 		    =	new Key(new int[] {KeyEvent.VK_UP, KeyEvent.VK_W});
        left 		=	new Key(new int[] {KeyEvent.VK_LEFT, KeyEvent.VK_A});
        right 		=	new Key(new int[] {KeyEvent.VK_RIGHT, KeyEvent.VK_D});
       /* numOne 	    =	new Key(new int[] {KeyEvent.VK_1});
        numTwo 	    =	new Key(new int[] {KeyEvent.VK_2});
        numThree 	=	new Key(new int[] {KeyEvent.VK_3});
        numFour 	=	new Key(new int[] {KeyEvent.VK_4});
        numFive 	=	new Key(new int[] {KeyEvent.VK_5});*/
        attack  	=	new Key(new int[] {KeyEvent.VK_SPACE,KeyEvent.VK_C, KeyEvent.VK_ENTER});
        escape 	    =	new Key(new int[] {KeyEvent.VK_ESCAPE});
    }

    AnyKey pressEvent;

    public class Key {
        public boolean pressed , clicked;
        public int presses , press_done;
        public int[] VK;

        public Key(int[] in) {
            VK = in;
            keys.add(this);
        }

        public void toggle(boolean in) {
            if (in != pressed) {
                pressed = in;
            }
            if(in) {
                presses++;
            }
        }

        public void tick() {
            if (press_done < presses) {
                press_done++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    public void tick() {
        for(Key key:keys) {
            key.tick();
        }
    }

    private List<Key> keys = new ArrayList<Key>();

    public Key down;
    public Key up;
    public Key left;
    public Key right;
    /*public Key numOne;
    public Key numTwo;
    public Key numThree;
    public Key numFour;
    public Key numFive;*/
    public Key attack;
    public Key escape;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void unPressAll() {
        for(Key key : keys) {
            key.pressed = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(pressEvent!=null) {
            pressEvent.onPress(e);
            pressEvent=null;
            return;
        }
        call(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        call(e, false);
    }

    public void call(KeyEvent e, boolean pressed) {
        int keyNum = e.getKeyCode();
        for (Key key:keys) {
            for(int vk:key.VK) {
                if(vk==keyNum) {
                    key.toggle(pressed);
                }
            }
        }
    }


    public void anyKey(AnyKey event) {
        pressEvent= event;
    }

    public static interface AnyKey {

        /**
         * called when a key is pressed
         * add this with (Input.anyKey(AnyKey event));
         */
        public abstract void onPress(KeyEvent e);
    }

    public Key key(int[] ints) {
        return new Key(ints);
    }

}
