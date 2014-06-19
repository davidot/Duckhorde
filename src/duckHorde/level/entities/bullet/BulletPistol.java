package duckHorde.level.entities.bullet;

import duckHorde.level.entities.Direction;
import duckHorde.level.entities.Entity;

import java.awt.Dimension;

/**
 * Created by David on 19-6-2014.
 * Duck hordes
 */
public class BulletPistol extends Entity {
    private int speed;

    public BulletPistol(Direction direction, int speed,int x,int y) {
        super(x,y);
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void tick() {
        move(direction,speed);
    }

    @Override
    public Dimension getSize() {
        return new Dimension(2,2);
    }
}
