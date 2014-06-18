package duckHorde.level.tiles;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.level.entities.Entity;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class AirTile extends Tile {
    public AirTile(int id) {
        super(id);
    }

    @Override
    public boolean mayPass(Level level,int x,int y,Entity e) {
        return true;
    }

    @Override
    public void render(Screen screen, Level level, int x, int y) {
        //Do  nothing with air
    }

}
