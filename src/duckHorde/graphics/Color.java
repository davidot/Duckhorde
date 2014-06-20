package duckHorde.graphics;

/**
 * Created by David on 20-6-2014.
 * Duck hordes
 */
public class Color {

       public static int create(int r,int g,int b) {
           return ((g % 255) << 8) + ((r % 255) << 16) + (b % 255);
       }

}
