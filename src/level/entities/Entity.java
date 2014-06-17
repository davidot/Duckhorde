package level.entities;

import graphics.Screen;
import level.Level;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public abstract class Entity {

    int x;
    int y;



    public abstract void render(Screen screen);


    public abstract  void tick(Level level);

}
