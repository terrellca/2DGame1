package main;

import javax.swing.JFrame;


public class Main  {
    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D WalkingSim");

        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);

        window.pack(); // makes the window sized to fit the preferred size and layouts of the subcomponents 


        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.startGameThread();
    }
}