package duckHorde.level;

import duckHorde.graphics.Screen;
import duckHorde.level.entities.Entity;
import duckHorde.level.entities.Player;
import duckHorde.level.tiles.Tile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class Level {

    private final int width;
    private final int height;

    private final int[] tiles;
    private final int[] data;
    public List<Entity> entities = new ArrayList<>();

    private Player player;

    public Level(int width, int height) {
        this.height = height;
        this.width = width;
        tiles = new int[height * width];
        data = new int[height * width];
        for(int i=0;i<tiles.length;i++) {
            tiles[i] = Tile.air.getID();
            data[i] = 0;
        }
        generateTest();
    }

    private void generateTest() {
        //TODO generate test duckHorde.level
        setTile(Tile.wall,0,0);
    }

    public void setTile( Tile t,int x,int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }
        tiles[x + y * width] = t.getID();
        setData(0,x,y);
    }

    public Tile getTile(int x,int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return Tile.wall;
        }
        return Tile.getTile(tiles[x + y * width]);
    }

    public void tick() {
        for(Iterator<Entity> i = entities.iterator(); i.hasNext(); ) {

            Entity e = i.next();
            e.tick();
            if(e.removed) {
                entities.remove(e);
            }
        }
    }

    public void render(Screen screen) {
        //TODO render tiles
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                getTile(x,y).render(screen,this,x,y);
            }
        }
        for(Entity e:entities) {
            e.render(screen);
        }
    }


    public void add(Entity e) {
        if(e instanceof Player && player==null) {
            player = (Player)e;
            //e.setPoint((width/2) * Game.PIXEL,(height/2) * Game.PIXEL);
        }
        entities.add(e);
        e.setLevel(this);
    }

    public int getData(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return 0;
        }
        return data[x + y * width];
    }

    public void setData(int d,int x,int y) {
        if(x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }
        data[x + y * width] = d;
    }

}
