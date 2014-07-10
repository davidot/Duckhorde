package duckHorde.level.entities;

import duckHorde.Game;
import duckHorde.graphics.Color;
import duckHorde.graphics.ImageRender;
import duckHorde.graphics.Render;
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
public class Player extends Mob{


    public static final int weaponXOff = 4;
    public static final int weaponYOff = 0;
    private static final int MIN_COMBOTICK = 15;

    private Input input;
    private int currentSlot = 0;
    private Gun[] guns;
    private ImageRender img;
    private int speed = 1;
    private int maxCombo = 0;
    private int combo = 0;
    private int comboTick = 0;

    public Player(int x,int y) {
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
        if(combo > 0) {
            maxCombo = Math.max(maxCombo,combo);
            if(comboTick >= (Math.max((100 - combo), MIN_COMBOTICK))) {
                combo--;
                comboTick = 0;
            } else {
                comboTick++;
            }
        } else {
            comboTick = 0;
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
        return new Dimension(16,16);
    }

    @Override
    public int getMaxHealth() {
        return 100;
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
        Render render = img.getCopy();
        //guns[currentSlot].render(render);
        screen.drawRotate(render,x,y,direction);
        screen.fillRect(x,y,16,16, Color.create(255,0,255));
    }

    public int getCombo() {
        return combo;
    }

    @Override
    public void killedEntity(Entity e) {
        combo++;
        comboTick = 0;
    }

}