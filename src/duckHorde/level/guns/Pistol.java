package duckHorde.level.guns;

import duckHorde.Game;
import duckHorde.graphics.Render;
import duckHorde.level.Level;
import duckHorde.level.entities.Player;
import duckHorde.level.entities.bullets.BulletPistol;
import duckHorde.util.combo.ComboAction;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class Pistol extends Gun {

    private int speed = 8;

    public Pistol() {
        setEnabled(true);
        Game.getComboHandler().add(new ComboAction(1) {
            @Override
            public void onAction() {
                speed = Math.max(speed,16);
            }
        });
    }

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
        l.add(new BulletPistol(p.getDirection(),this,p.getLocation().x,p.getLocation().y));
    }

    @Override
    public void render(Render render) {

    }
}
