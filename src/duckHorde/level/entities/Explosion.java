package duckHorde.level.entities;

import java.awt.Dimension;

/**
 * Created by David on 6-7-2014.
 * Duck hordes
 */
public class Explosion extends Entity {
    private static final int MAX_TICKS = 25;
    private final Entity from;
    private int radius;
    private int tick = 0;
    private int damage;

    public Explosion(int x, int y, int r,Entity from,int damage) {
        super(x,y);
        radius = r;
        this.from = from;
        this.damage = damage;
    }

    @Override
    public void onCollisionTile() {

    }

    @Override
    public Dimension getSize() {
        return new Dimension(radius,radius);
    }

    @Override
    public void killedEntity(Entity e) {

    }

    @Override
    public void tick() {
        if(tick <= 0) {
            damageRadius();
        }
        tick++;
        if(tick > MAX_TICKS) {
            this.remove();
        }
    }

    private void damageRadius() {
        for(Entity e: level.entities) {
            if(!(e instanceof Mob)) {
                continue;
            }
            if(from!=null && from==e) {
                continue;
            }
            int dx =x - e.x, dy = y - e.x;
            if((Math.sqrt((dx * dx) + (dy * dy))) <= radius ){
                ((Mob)e).hurt(from,damage);
            }
        }
    }
}