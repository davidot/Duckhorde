package duckHorde.level.tiles;

import duckHorde.Game;
import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.level.entities.Entity;
import duckHorde.level.entities.Explosion;
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
            level.add(new Explosion(x * Game.PIXEL,y * Game.PIXEL,Game.PIXEL * 3,null,level.getData(x,y)));
            level.setTile(Tile.air,x,y);
        }
    }
}
