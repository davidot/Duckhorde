package duckHorde.level.guns;

import duckHorde.level.Level;
import duckHorde.level.entities.Player;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class Pistol extends Gun {
    @Override
    public String getName() {
        return "Pistol";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int getAmmo() {
        return -1;
    }

    @Override
    public void shoot(Player p, Level l) {

    }
}
