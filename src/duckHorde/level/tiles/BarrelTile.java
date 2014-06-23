package duckHorde.level.tiles;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.level.entities.Entity;
import duckHorde.level.entities.bullets.Bullet;

/**
 * Created by David on 23-6-2014.
 * Duck hordes
 */
public class BarrelTile extends Tile{
    public BarrelTile(int id) {
        super(id);
    }

    @Override
    public boolean mayPass(Level level, int x, int y, Entity e) {
        return false;
    }

    @Override
    public void render(Screen screen, Level level, int x, int y) {

    }

    @Override
    public void onTouch(Level level, int x, int y, Entity e) {
        if(e instanceof Bullet) {
            int oldHealth = level.getData(x,y);
            int newHealth = oldHealth - ((Bullet)e).getDamage();
            if(newHealth < 0) {
                level.setTile(Tile.air,x,y);
                return;
            }
            if(newHealth!=oldHealth) {
                level.setData(newHealth,x,y);
            }
        }
    }
}
