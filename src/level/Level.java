package level;

import level.tiles.Tile;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class Level {

    private int width;
    private int height;

    private int[] tiles;

    public Level(int width,int height) {
        this.height = height;
        this.width = width;
        tiles = new int[height * width];
        generateTest();
    }

    private void generateTest() {

    }

    private void setTile(Tile t,int x,int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }
        tiles[x + y * width] = t.getID();
    }

    private Tile getTile(Tile t,int x,int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return Tile.wall;
        }
        return Tile.getTile(tiles[x + y * width]);
    }




}
