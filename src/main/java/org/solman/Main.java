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

    public void getIntegerInput(){
        String retVal = "";
        boolean isTrue = false;
        BufferedReader bufferedReader = bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Enter number of seeds: (recommended 50000-1000000)");
            retVal = bufferedReader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!isNumericValue(retVal)){
            getIntegerInput();
        }
        else {
            seeds = Integer.parseInt(retVal);
        }
    }

    private boolean isNumericValue(String input) {
        try {
            int test = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid Integer!");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Main m = new Main();
    }
}