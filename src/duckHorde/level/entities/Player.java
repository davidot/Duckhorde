package duckHorde.level.entities;

import duckHorde.level.guns.Gun;
import duckHorde.util.Input;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class Player extends Entity{


    private Input input;
    private int currentSlot;
    private Gun[] guns = new Gun[9];

    public Player(int x, int y) {
        super(x, y);

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

        }
    }

    public void setInput(Input input) {
        this.input = input;
    }
}
