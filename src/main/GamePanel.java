package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    //Settings for screen

    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 18; //16 titles horizontally
    final int maxScreenRow = 14; //12 titles vertically
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //Tracks game time.
    Thread gameThread;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }


    public void startGameThread(){
        gameThread = new Thread(this); //passing game panel to the thread constructor.
        gameThread.start();
    }

    @Override
    public void run() {
        

        while(gameThread != null)
        {
            //Update Character Position
            update();

            //Draw Screen with updated info
            repaint();


        }



        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    public void update()
    {

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D graphicsD = (Graphics2D)g;

        graphicsD.setColor(Color.WHITE);

        graphicsD.fillRect(100, 100, tileSize, tileSize);

        graphicsD.dispose();
    }

}
