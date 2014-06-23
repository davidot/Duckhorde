package duckHorde.level.entities.bullets;

import duckHorde.level.entities.Direction;
import duckHorde.level.guns.Gun;

/**
 * Created by David on 20-6-2014.
 * Duck hordes
 */
public class BulletShotGun extends Bullet{
    public BulletShotGun(Direction direction,Gun gun,int x, int y) {
        super(direction,gun, x, y);
    }
}
