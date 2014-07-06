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
    private int maxDistance;

    public Bullet(Direction direction,Gun gun,int x,int y) {
        super(x,y);
        this.speed = gun.getSpeed();
        this.damage = gun.getDamage();
        this.direction = direction;
        this.maxDistance = gun.getMaxDistance();
    }

    @Override
    public void tick() {
        if(maxDistance > 0) {
            move(direction,speed);
            maxDistance--;
        }
    }

    @Override
    public void onCollisionTile() {
        remove();
    }

    @Override
    public Dimension getSize() {
        return new Dimension(2,2);
    }

    @Override
    public void killedEntity(Entity e) {
    }

    public int getDamage() {
        return damage;
    }
}
