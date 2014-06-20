package duckHorde.level.tiles;

import duckHorde.Game;
import duckHorde.graphics.Color;
import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.level.entities.Entity;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class WallTile extends Tile {
    public WallTile(int id) {
        super(id);
    }

    @Override
    public boolean mayPass(Level level,int x,int y,Entity e) {
        return false;
    }

    @Override
    public void render(Screen screen, Level level, int x, int y) {
        screen.fillRect(Game.PIXEL * x,Game.PIXEL * y,Game.PIXEL, Game.PIXEL, Color.createAlpha(255, 0, 0, 255));
    }


}
