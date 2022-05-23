package org.solman;


import org.solman.game.Screen;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        int width = 600;
        int height = 400;
        int seeds = 75000;
        Screen screen = new Screen(height, width, seeds);
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(screen);
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}