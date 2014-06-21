package duckHorde.level.entities;

import duckHorde.level.guns.Gun;
import duckHorde.util.Input;

import java.awt.Dimension;

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

    public Player(int x, int y) {
        super(x, y);
        guns = Gun.generateGunArray();
    }

    @Override
    public void tick() {
        if(input.left.clicked&&!input.right.clicked) {
            x--;
        }
        if(input.right.clicked&&!input.left.clicked) {
            x++;
        }
        if(input.up.clicked&&!input.down.clicked) {
            y--;
        }
        if(input.down.clicked&&!input.up.clicked) {
            y++;
        }
        for(int i = 0; i <input.numberKeys.size(); i++) {
            if(input.numberKeys.get(i).pressed) {
                if(guns[i].getAmmo() > 0) {
                    currentSlot = i;
                    break;
                }
            }
        }
        if(input.attack.pressed) {
            guns[currentSlot].fire(this,level);
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
}
