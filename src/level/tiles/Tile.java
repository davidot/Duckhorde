package level.tiles;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public abstract class Tile {

    private int id;

    public Tile(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }
}
