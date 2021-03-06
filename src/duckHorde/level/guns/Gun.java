package duckHorde.level.guns;

import duckHorde.graphics.Render;
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
    private int speed = 8;
    private int damage = 1;
    private int reloadTime = 0;


    public int getAmmo() {
        return ammo;
    }

    public void useAmmo() {
        if(maxAmmo>0){
            if(ammo > 0){
                ammo--;
            }
        }
        reloadTime = getReloadTimer();
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
        if(getAmmo() !=0&&reloadTime<=0) {
            shoot(p,l);
            useAmmo();
        } else {
            if(reloadTime > 0) {
                reloadTime--;
            }
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

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getMaxDistance() {
        return 100;
    }

    public int getReloadTimer() {
        return 50;
    }

    public abstract void render(Render render);
}
