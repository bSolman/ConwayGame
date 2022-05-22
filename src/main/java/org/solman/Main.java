package org.solman;


import org.solman.game.Screen;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main extends JFrame {

    private int seeds = 100000;
    public Main(){
        int width = 500;
        int height = 500;
        Screen screen = new Screen(width, height, seeds);
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