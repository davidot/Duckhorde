package duckHorde.level.guns;

import duckHorde.graphics.Render;
import duckHorde.level.Level;
import duckHorde.level.entities.Player;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class UZI extends Gun {
    @Override
    public String getName() {
        return "UZI";
    }

    @Override
    public void shoot(Player p, Level l) {

    }

    @Override
    public void render(Render render) {

    }

    @Override
    public int getReloadTimer() {
        return 2;
    }
}
