package level.tiles;

import level.Level;
import level.entities.Entity;

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
}
