package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

    public boolean upmove, downmove, rightmove, leftmove;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W)
        {
            upmove = true;
        }

        if (code == KeyEvent.VK_A)
        {
            leftmove = true;
        }

        if (code == KeyEvent.VK_S)
        {
            downmove = true;
        }

        if (code == KeyEvent.VK_D)
        {
            rightmove = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

       int code = e.getKeyCode();

       if (code == KeyEvent.VK_W)
       {
           upmove = false;
       }

       if (code == KeyEvent.VK_A)
       {
           leftmove = false;
       }

       if (code == KeyEvent.VK_S)
       {
           downmove = false;
       }

       if (code == KeyEvent.VK_D)
       {
           rightmove = false;
       }

    }
    
}
