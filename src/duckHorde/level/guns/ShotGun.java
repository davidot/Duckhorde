package duckHorde.level.guns;

import duckHorde.graphics.Render;
import duckHorde.level.Level;
import duckHorde.level.entities.Player;
import duckHorde.level.entities.bullets.BulletShotGun;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class ShotGun extends Gun {
    private int bulletAmount = 8;

    @Override
    public String getName() {
        return "Shotgun";
    }

    @Override
    public void shoot(Player p, Level l) {
        if(p.getDirection().isHorizontal()){
            for(int y = 0;y<bulletAmount;y++) {
                l.add(new BulletShotGun(p.getDirection(),this,p.getLocation().x,p.getLocation().y + y));
            }
        } else {
            for(int x = 0;x<bulletAmount;x++) {
                l.add(new BulletShotGun(p.getDirection(),this,p.getLocation().x + x,p.getLocation().y));
            }
        }
    }

    @Override
    public void render(Render render) {

    }
}
