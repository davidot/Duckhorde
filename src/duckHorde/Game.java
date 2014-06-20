package duckHorde;

import duckHorde.graphics.Screen;
import duckHorde.level.Level;
import duckHorde.util.Input;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

/**
 * Created by David on 14-6-2014.
 * Duck hordes
 */
public class Game extends Canvas implements Runnable {

    private static final int FIXED_WIDTH = 800;
    private static final int FIXED_HEIGHT = 450;
    private static final String TITLE = "Duck hordes";
    private static final int LEVEL_WIDTH = 50;
    private static final int LEVEL_HEIGHT = 50;
    public static final int PIXEL = 32;


    /*  Rendering stuff */
    private Screen screen;
    private boolean running;
    private BufferedImage renderImg;
    private int[] pixels;

    private Thread mainThread;
    /* Game stuff */
    public Level level;
    public Input input;
    public int gameTime;
    private BufferedImage test;


    public Game() {
        Dimension prefSize = new Dimension(FIXED_WIDTH, FIXED_HEIGHT);
        this.setPreferredSize(prefSize);
        screen = new Screen(FIXED_WIDTH, FIXED_HEIGHT);
        renderImg = new BufferedImage(FIXED_WIDTH,FIXED_HEIGHT,BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)renderImg.getRaster().getDataBuffer()).getData();
        level = new Level(LEVEL_WIDTH,LEVEL_HEIGHT);
        input = new Input(this);
        input.unpressedAll();
        try {
            test = ImageIO.read(Game.class.getResourceAsStream("res/img/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        int frames = 0;
        double unprocessedSec = 0.0;
        long previousTime = System.nanoTime();
        double tps = 1/60.0;
        int tickCount = 0;
        boolean ticked = false;

        
        while(running) {
            long currentTime = System.nanoTime();
            long passedTime = currentTime - previousTime;
            previousTime = currentTime;
            unprocessedSec += passedTime / 1000000000.0;
            while (unprocessedSec > tps) {
                tick();
                unprocessedSec -= tps;
                ticked = true;
                tickCount++;
                if(tickCount % 60 == 0) {
                    System.out.println(frames + " fps");
                    previousTime += 1000;
                    frames = 0;
                }
            }
            if(ticked) {
                render();
                frames++;
            }
            render();
            frames++;
        }
    }

    private void render() {
        BufferStrategy strategy = getBufferStrategy();
        if(strategy==null) {
            createBufferStrategy(3);
            requestFocus();
            return;
        }
        //Rendering screen on image

        screen.render(this);

        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        //System array copy uses full blocks to copy faster(instead of individual numbers)

        Graphics g = strategy.getDrawGraphics();
        //g.clearRect(0,0,FIXED_WIDTH,FIXED_HEIGHT);
        g.drawImage(renderImg,0,0,null);
        g.dispose();
        strategy.show();
    }

    private void tick() {
        gameTime++;
        input.tick();
        level.tick();
    }


    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle(TITLE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        game.start();

    }


    public void start() {
        if(running) {
            return;
        }
        running = true;
        mainThread = new Thread(this);
        mainThread.start();
    }

    public void stop() {
        if(!running) {
            return;
        }
        running = false;
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void renderScreen(Screen screen) {
        level.render(screen);
        screen.drawImage(test,64,64);

    }
}
