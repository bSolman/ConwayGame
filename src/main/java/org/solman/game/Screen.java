package org.solman.game;

import org.solman.conway.cellInterface.ICell;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Screen extends JPanel {
    private final GameController GAME_CONTROLLER;

    public Screen(int height, int width, int seeds){
        GAME_CONTROLLER = new GameController(height, width, seeds);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        List<ICell> currentList = GAME_CONTROLLER.getCellList();
        runDraw(graphics, currentList);
        GAME_CONTROLLER.setNrOfCellNeighbours();
        GAME_CONTROLLER.updateCells();
        GAME_CONTROLLER.updateCellArray();
        repaint();
    }

    private void runDraw(Graphics graphics, List<ICell> currentList) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (ICell cell : currentList) {
            if (cell.isAlive()) {
                graphics.setColor(Color.BLUE);
                graphics.fillRect(cell.getPOS_X(), cell.getPOS_Y(), 1, 1);
            }
        }
    }
}
