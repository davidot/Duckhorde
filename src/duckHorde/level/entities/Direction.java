package duckHorde.level.entities;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public enum Direction {

    UP,
    DOWN,
    RIGHT,
    LEFT;

    public boolean isHorizontal() {
        return this==LEFT || this==RIGHT;
    }

    public boolean isVertical() {
        return this==UP || this==DOWN;
    }

}
