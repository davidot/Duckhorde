package duckHorde.graphics;

import duckHorde.Game;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Created by David on 14-6-2014.
 * Duck hordes
 */
public class Screen extends Render {



    public Screen(int width,int height) {
        super(width, height);
    }

   public void fillRect(int x,int y,int width,int height,int color) {
       draw(new FilledRender(width,height,color),x,y);
   }

   public void fillRect(Rectangle r,int color) {
       fillRect(r.x,r.y,r.width,r.height,color);
   }


    public void drawImage(BufferedImage img,int x,int y) {
        draw(new ImageRender(img),x,y);
    }



   public void render(Game game) {
       reset();
       game.renderScreen(this);
    }
}
