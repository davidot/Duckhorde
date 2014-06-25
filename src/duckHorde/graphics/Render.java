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
    public int xOffset = 0;
    public int yOffset = 0;

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
        if(xPos > (xOffset + width) || (xPos + render.width) < xOffset) {
            return;
        }
        if(yPos > (yOffset + height) || (yPos + render.height) < yOffset) {
            return;
        }
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
        if(xPos > (xOffset + width) || (xPos + render.width) < xOffset) {
            return;
        }
        if(yPos > (yOffset + height) || (yPos + render.height) < yOffset) {
            return;
        }
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

    public void drawXRev(Render render, int xPos, int yPos) {
        if(xPos > (xOffset + width) || (xPos + render.width) < xOffset) {
            return;
        }
        if(yPos > (yOffset + height) || (yPos + render.height) < yOffset) {
            return;
        }
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
                pixels[xNew + yNew * width] = render.pixels[((render.width-1)-x) +  y * render.width];
            }
        }
    }

    public void drawFlipLeft(Render render, int xPos, int yPos) {
        if(xPos > (xOffset + width) || (xPos + render.width) < xOffset) {
            return;
        }
        if(yPos > (yOffset + height) || (yPos + render.height) < yOffset) {
            return;
        }
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
                pixels[xNew + yNew * width] = render.pixels[y + x * render.width];
            }
        }
    }

    public void drawFlipRight(Render render, int xPos, int yPos) {
        if(xPos > (xOffset + width) || (xPos + render.width) < xOffset) {
            return;
        }
        if(yPos > (yOffset + height) || (yPos + render.height) < yOffset) {
            return;
        }
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
                pixels[xNew + yNew * width] = render.pixels[((render.height-1) - y) + ((render.width-1)-x) * render.width];
            }
        }
    }


    public void drawRotate(Render render,int xPos,int yPos,Direction dir) {
        switch (dir) {
            case RIGHT:
                drawFlipRight(render,xPos,yPos);
                break;
            case LEFT:
                drawFlipLeft(render,xPos,yPos);
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
