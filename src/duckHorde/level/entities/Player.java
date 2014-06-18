package duckHorde.level.entities;

import duckHorde.util.Input;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class Player extends Entity{


    private Input input;

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
    }

    public void setInput(Input input) {
        this.input = input;
    }
}