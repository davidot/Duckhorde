package duckHorde.graphics;

import java.awt.image.BufferedImage;

/**
 * Created by David on 20-6-2014.
 * Duck hordes
 */
public class ImageRender extends Render {
    public ImageRender(BufferedImage img) {
        super(img.getWidth(),img.getHeight());
        this.pixels = img.getRGB(0,0,width,height,null,0,width);
    }

    private ImageRender(ImageRender from) {
        super(from.width,from.height);
        System.arraycopy(pixels, 0, from.pixels, 0, from.pixels.length);
    }

    public ImageRender getCopy() {
        return new ImageRender(this);
    }
}
