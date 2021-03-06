package duckHorde.level.entities.bullets;

import duckHorde.graphics.Color;
import duckHorde.graphics.Screen;
import duckHorde.level.entities.Direction;
import duckHorde.level.entities.Entity;
import duckHorde.level.guns.Gun;

import java.awt.Dimension;
import java.awt.Rectangle;

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
        } else {
            remove();
        }
    }

    @Override
    public void onCollisionTile() {
        remove();
    }

    @Override
    public Dimension getSize() {
        return new Dimension(4,2);
    }

    @Override
    public void killedEntity(Entity e) {
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void render(Screen screen) {
        screen.fillRect(new Rectangle(getLocation(),getSize()), Color.create(100,100,100));
    }
}
