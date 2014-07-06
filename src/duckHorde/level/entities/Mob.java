package duckHorde.level.entities;

/**
 * Created by David on 6-7-2014.
 * Duck hordes
 */
public abstract class Mob  extends Entity{

    private int health;

    public Mob(int x, int y) {
        super(x, y);
        health = getMaxHealth();
    }

    public abstract int getMaxHealth();

    public void hurt(Entity from,int damage) {
        if(getMaxHealth() < 0) {
            return;
        }
        if(health - damage <= 0) {
            from.killedEntity(this);
            remove();
            health = 0;
            return;
        }
        health = health - damage;
    }

}