package duckHorde.level.entities.bullets;

import duckHorde.level.entities.Direction;
import duckHorde.level.entities.Entity;
import duckHorde.level.guns.Gun;

import java.awt.Dimension;

/**
 * Created by David on 19-6-2014.
 * Duck hordes
 */
public class Bullet extends Entity {

    private int speed;
    private int damage;

    public Bullet(Direction direction,Gun gun,int x,int y) {
        super(x,y);
        this.speed = gun.getSpeed();
        this.damage = gun.getDamage();
        this.direction = direction;
    }

    @Override
    public void tick() {
        move(direction,speed);
    }

    @Override
    public void onCollisionTile() {

    }

    @Override
    public Dimension getSize() {
        return new Dimension(2,2);
    }

    public int getDamage() {
        return damage;
    }
}
