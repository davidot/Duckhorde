package duckHorde.level.guns;

import duckHorde.level.Level;
import duckHorde.level.entities.Player;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public abstract class Gun {

    private int ammo = 0;
    private boolean enabled = false;

    /**
     * If maxAmmo is less than 0 infinite ammo is used
     */
    private int maxAmmo = -1;


    public int getAmmo() {
        return ammo;
    }

    public void useAmmo() {
        if(maxAmmo>0){
            if(ammo > 0){
                ammo--;
            }
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public abstract String getName();

    public abstract void shoot(Player p,Level level);

    public void fire(Player p,Level l) {
        if(getAmmo() !=0) {
            shoot(p,l);
            useAmmo();
        }
    }

    public static Gun[] generateGunArray() {
        Gun[] guns = new Gun[9];
        guns[0] = new Pistol();
        guns[1] = new UZI();
        guns[2] = new ShotGun();
        guns[3] = new BarrelGun();
        guns[4] = new GrenadeGun();
        guns[5] = new WallGun();
        guns[6] = new MineGun();
        guns[7] = new RocketLauncher();
        guns[8] = new RailGun();
        return guns;
    }
}
