package duckHorde.level.entities;

import duckHorde.Game;
import duckHorde.graphics.ImageRender;
import duckHorde.graphics.Screen;
import duckHorde.level.guns.Gun;
import duckHorde.util.Input;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.io.IOException;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class Player extends Entity{


    public static final int weaponXOff = 4;
    public static final int weaponYOff = 0;

    private Input input;
    private int currentSlot;
    private Gun[] guns;
    private ImageRender img;
    private int speed = 1;

    public Player(int x, int y) {
        super(x, y);
        guns = Gun.generateGunArray();
        try {
            img = new ImageRender(ImageIO.read(Game.class.getResourceAsStream("res/img/player.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
        if(input.left.clicked&&!input.right.clicked) {
            move(Direction.LEFT,speed);
        }
        if(input.right.clicked&&!input.left.clicked) {
           move(Direction.RIGHT,speed);
        }
        if(input.up.clicked&&!input.down.clicked) {
            move(Direction.UP,speed);
        }
        if(input.down.clicked&&!input.up.clicked) {
            move(Direction.DOWN,speed);
        }
        for(int i = 0; i <input.numberKeys.size(); i++) {
            if(input.numberKeys.get(i).pressed) {
               setCurrentSlot(i);
            }
        }
        if(input.attack.pressed) {
            guns[currentSlot].fire(this,level);
            checkGun();
        }
    }

    private void checkGun() {
        if(gunReady(currentSlot)) {
            return;
        }
        while(!gunReady(currentSlot)) {
            currentSlot--;
            if(currentSlot<0) {
                currentSlot = 0;
                break;
            }
        }

    }

    @Override
    public void onCollisionTile() {

    }

    @Override
    public Dimension getSize() {
        return new Dimension(32,32);
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public boolean gunReady(int slot) {
        if(slot < 0 || slot >= guns.length) {
            return false;
        }
        Gun g = guns[slot];
        if(!g.isEnabled()||g.getAmmo()==0) {
            return false;
        }

        return true;
    }

    public void setCurrentSlot(int newSlot) {
        if(!gunReady(newSlot)) {
            return;
        }
        currentSlot = newSlot;
    }

    @Override
    public void render(Screen screen) {
        screen.drawRotate(img,x,y,direction);
    }
}
