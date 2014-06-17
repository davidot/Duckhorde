package duckHorde.graphics;

/**
 * Created by David on 17-6-2014.
 * Duck hordes
 */
public class FilledRender extends Render {

    public FilledRender(int width, int height,int color) {
        super(width,height);
        for(int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

}