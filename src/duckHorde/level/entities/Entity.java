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

    protected Direction direction = Direction.UP;

    protected int x;
    protected int y;
    protected Level level;
    public boolean removed;

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
        System.out.println("Moving " + d + "with " + speed + "as " + this.getClass().getName());
        int xNew = x,yNew = y;
        switch (d) {
            case DOWN:
                yNew += speed;
                break;
            case UP:
                yNew -= speed;
                break;
            case LEFT:
                xNew -= speed;
                break;
            case RIGHT:
                xNew += speed;
                break;
        }
        int xLevel = xNew /16, yLevel = yNew /16;
        System.out.println("X:" + xNew + "Y:" + yNew);
        System.out.println("XLEVEL:" + xLevel + "YLEVEL:" + yLevel);
        if(!level.getTile(xLevel,yLevel).mayPass(level,xLevel,yLevel,this)) {
            onCollisionTile();
            level.getTile(xLevel,yLevel).onTouch(level,xLevel,yLevel,this);
            return;
        }
        x = xNew;
        y = yNew;
        direction = d;
        checkCollisionEntities();
    }

    public void checkCollisionEntities() {

        for(Entity e:level.entities) {
            Rectangle thisSize = new Rectangle(this.getLocation(),this.getSize());
            Rectangle thatSize = new Rectangle(e.getLocation(),e.getSize());
            if(thisSize.intersects(thatSize)) {
                e.touch(this);
            }
        }
    }

    public abstract void onCollisionTile();

    public abstract Dimension getSize();

    public void remove() {
        removed = true;
    }
}
