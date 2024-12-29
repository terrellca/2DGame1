package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
    //Settings for screen

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 18; //16 titles horizontally
    final int maxScreenRow = 14; //12 titles vertically
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;


    Keyboard keyH = new Keyboard();

    //Tracks game time.
    Thread gameThread;


    Player player = new Player(this, keyH);

    //Players default pos
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;



    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);

        this.addKeyListener(keyH);
        this.setFocusable(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this); //passing game panel to the thread constructor.
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; //1 billion nanoseconds divided by the FPS.
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null)
        {
            //Update Character Position
            update();

            //Draw Screen with updated info
            repaint();

            try {
                //Subtract current time from the nextDraw time
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0)
                {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); //Pauses the game loop.
                nextDrawTime += drawInterval;

            } catch (Exception e) {
                e.printStackTrace();
            }
            
            


        }

    }

    public void update()
    {
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphicsD = (Graphics2D)g;

        player.draw(graphicsD);

        graphicsD.dispose();
    }

}
