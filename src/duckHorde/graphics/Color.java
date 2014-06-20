package duckHorde.graphics;

/**
 * Created by David on 20-6-2014.
 * Duck hordes
 */
public class Color {

       public static int createAlpha(int r, int g, int b, int a) {
           return ((r % 256) << 16) + ((g % 256) << 8) + ((a % 256) << 24) + (b%256);
       }

       public static int create(int r,int g,int b) {
           return createAlpha(r, g, b, 255);
       }

}
