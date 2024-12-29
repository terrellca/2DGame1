package entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.GamePanel;
import main.Keyboard;

public class Player extends Entity{
    
    GamePanel gp;
    Keyboard keyH;

    public Player(GamePanel gp, Keyboard keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultPlayer();
    }


    public void setDefaultPlayer()
    {
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update()
    {
        //moves the player by the player speed. (4 pixels as of nbow)
        if(keyH.upmove == true){
            y -= speed;
        }
        else if(keyH.downmove == true)
        {
            y += speed;
        }
        else if(keyH.leftmove == true)
        {
            x -= speed;
        }
        else if(keyH.rightmove == true)
        {
            x += speed;
        }
    }

    public void draw(Graphics2D graphicsD)
    {
        graphicsD.setColor(Color.WHITE);

        graphicsD.fillRect(x, y, gp.tileSize, gp.tileSize); //Redraws the recatangle with the updated cords.

    }
}
