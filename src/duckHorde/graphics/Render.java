package duckHorde.graphics;

import duckHorde.level.entities.Direction;

/**
 * Created by David on 14-6-2014.
 * Duck hordes
 */
public class Render {

    public int width;
    public int height;
    public int[] pixels;

    public Render(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void reset() {
        for(int i=0;i<pixels.length;i++) {
            pixels[i] = 0;
        }
    }

    public void draw(Render render, int xPos, int yPos) {
        for (int x = 0; x < render.width; x++) {
            int xNew = x + xPos;
            if (xNew < 0 || xNew >= width) {
                continue;
            }
            for (int y = 0; y < render.height; y++) {
                int yNew = y + yPos;
                if (yNew < 0 || yNew >= height) {
                    continue;
                }
                pixels[xNew + yNew * width] = render.pixels[x + y * render.width];
            }
        }
    }

    public void drawYRev(Render render, int xPos, int yPos) {
        for (int x = 0; x < render.width; x++) {
            int xNew = x + xPos;
            if (xNew < 0 || xNew >= width) {
                continue;
            }
            for (int y = 0; y < render.height; y++) {
                int yNew = y + yPos;
                if (yNew < 0 || yNew >= height) {
                    continue;
                }
                pixels[xNew + yNew * width] = render.pixels[x + ((render.height-1) - y) * render.width];
            }
        }
    }




    public void drawRotate(Render render,int xPos,int yPos,Direction dir) {
        switch (dir) {
            case RIGHT:

                break;
            case LEFT:

                break;
            case UP:
                draw(render,xPos,yPos);
                break;
            case DOWN:
                drawYRev(render,xPos,yPos);
                break;
        }
    }

}
