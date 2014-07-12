package duckHorde.util.combo;

import duckHorde.level.entities.Player;

/**
 * Created by David on 12-7-2014.
 * Duck hordes
 */
public abstract class ComboAction {

    private int num = -1;

    public ComboAction(int num) {
        this.num = num;
    }

    public abstract void onAction(Player player);
}