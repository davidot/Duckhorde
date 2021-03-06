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

    /**
     *
     * @param e entity which touched this entity
     */
    public void touch(Entity e) {
        if(e instanceof Mob) {
            System.out.println("Mob touched::" + this.getClass().getName());
            //Its a mob
        }
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
        direction = d;
        int xLevel = xNew /32, yLevel = yNew /32;
        int xLevelWidth = (xNew + getSize().width) / 32, yLevelHeight = (yNew + getSize().height) /32;
        System.out.println("X:" + xNew + "Y:" + yNew);
        System.out.println("XLEVEL:" + xLevel + "YLEVEL:" + yLevel);
        if(!level.getTile(xLevel,yLevel).mayPass(level,xLevel,yLevel,this)) {
            onCollisionTile();
            level.getTile(xLevel,yLevel).onTouch(level,xLevel,yLevel,this);
            return;
        }
        if(!level.getTile(xLevelWidth,yLevelHeight).mayPass(level,xLevelWidth,yLevelHeight,this)) {
            onCollisionTile();
            level.getTile(xLevelWidth,yLevelHeight).onTouch(level,xLevelWidth,yLevelHeight,this);
            return;
        }
        if(!level.getTile(xLevel,yLevelHeight).mayPass(level,xLevel,yLevelHeight,this)) {
            onCollisionTile();
            level.getTile(xLevel,yLevelHeight).onTouch(level,xLevel,yLevelHeight,this);
            return;
        }
        if(!level.getTile(xLevelWidth,yLevel).mayPass(level,xLevelWidth,yLevel,this)) {
            onCollisionTile();
            level.getTile(xLevelWidth,yLevel).onTouch(level,xLevelWidth,yLevel,this);
            return;
        }

        x = xNew;
        y = yNew;

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

    public abstract void killedEntity(Entity e);
}
