package duckHorde.graphics;

import duckHorde.Game;

import java.awt.Rectangle;

/**
 * Created by David on 14-6-2014.
 * Duck hordes
 */
public class Screen extends Render {



    public Screen(int width, int height) {
        super(width, height);
    }

   public void fillRect(int x,int y,int width,int height,int color) {
        draw(new FilledRender(width,height,color),x,y);
   }

   public void fillRect(Rectangle r,int color) {
       fillRect(r.x,r.y,r.width,r.height,color);
   }

    public void render(Game game) {
        for(int i = 0;i<pixels.length;i++) {
            pixels[i] = 0;
        }
        game.level.render(this);


    }
}
