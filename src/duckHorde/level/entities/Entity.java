package duckHorde.level.entities;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public abstract class Entity {

    protected Direction direction;

    protected int x;
    protected int y;
    protected Level level;

    public Entity(int x,int y) {
        this.x = x;
        this.y = y;
    }


    public void render(Screen screen) {
        //Default method don't render anything
    }


    public void tick() {
        //Default method don't do anything
    }

    public void touch(Entity e) {
        //Default method don't do anything
    }

    public Point getLocation() {
        return new Point(x,y);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Direction d,int speed) {
        switch (d) {
            case DOWN:
                y += speed;
                break;
            case UP:
                y -= speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
        checkCollision();
    }

    public void checkCollision() {
        for(Entity e:level.entities) {
            Rectangle thisSize = new Rectangle(this.getLocation(),this.getSize());
            Rectangle thatSize = new Rectangle(e.getLocation(),e.getSize());
            if(thatSize.intersects(thatSize)) {
                e.touch(this);
            }
        }
    }

    public abstract Dimension getSize();
}
