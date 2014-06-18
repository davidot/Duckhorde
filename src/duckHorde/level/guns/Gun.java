package duckHorde.level.guns;

import duckHorde.level.Level;
import duckHorde.level.entities.Player;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public abstract class Gun {

    private int ammo = 0;

    /**
     * If maxAmmo is less than 0 infinite ammo is used
     */
    private int maxAmmo = -1;


    public int getAmmo() {
        return ammo;
    }

    public abstract String getName();

    public abstract void shoot(Player p,Level l);

}
