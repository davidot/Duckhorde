package duckHorde.level.tiles;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.level.entities.Entity;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public abstract class Tile {

    private int id;

    private static final Tile[] tiles = new Tile[16];
    public static final Tile air = new AirTile(0);
    public static final Tile wall = new WallTile(1);


    public Tile(int id) {
        if(getTileNull(id)!=null) {
            throw new IllegalArgumentException("Tile id conflict, tried to place" + this.getClass().getName() + "at slot " + id + " while " + getTileNull(id).getClass().getName() + "already exists.");
        }
        this.id = id;
        tiles[id] = this;
    }

    public int getID() {
        return id;
    }

    /**
     * Gets the tile with the id given
     * if id is out of range or the tile at that spot is null Tile.wall is returned
     * @param id id to load tile from
     * @return tile with id given or Tile.wall
     */
    public static Tile getTile(int id) {
        if(id < 0 || id >= tiles.length) {
            return wall;
        }
        if(tiles[id]==null) {
            return wall;
        }
        return tiles[id];
    }

    private static Tile getTileNull(int id) {
        if(id < 0 || id >= tiles.length) {
            return null;
        }
        return tiles[id];
    }

    public abstract boolean mayPass(Level level,int x,int y,Entity e);

    public abstract void render(Screen screen,Level level,int x,int y);

}
