package duckHorde.level.entities;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;

import java.awt.Point;

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

    public Level getLevel() {
        return level;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
