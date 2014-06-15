package graphics;

import java.util.Random;

/**
 * Created by David on 14-6-2014.
 */
public class Screen extends Render {

    private Render test;

    public Screen(int width, int height) {
        super(width, height);
        test = new Render(200,200);
        Random rand = new Random();
        for(int i=0;i < 200 * 200;i++) {
            System.out.println("adding:" + i);
            test.pixels[i] = rand.nextInt();
        }
    }

    public void render() {
        for(int i = 0;i<pixels.length;i++) {
            pixels[i] = 0;
        }

        draw(test,0,0);


    }

}
