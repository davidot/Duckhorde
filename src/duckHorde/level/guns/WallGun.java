package duckHorde.level.guns;

import duckHorde.graphics.Render;
import duckHorde.level.Level;
import duckHorde.level.entities.Player;
import duckHorde.level.tiles.Tile;

/**
 * Created by David on 18-6-2014.
 * Duck hordes
 */
public class WallGun extends Gun {
    @Override
    public String getName() {
        return "Walls";
    }

    @Override
    public void shoot(Player p, Level l) {
        int xPlace = p.getLocation().x >> 4, yPlace = p.getLocation().y >> 4;
        if(l.getTile(xPlace,yPlace) == Tile.air) {
            l.setTile(Tile.wall, xPlace, yPlace);
        }
    }

    @Override
    public void render(Render render) {

    }
}
