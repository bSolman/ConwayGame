package org.solman.game;


import org.solman.conway.cellInterface.ICell;
import org.solman.conway.logic.CellLogic;

import java.util.List;
import java.util.Random;

public class GameController {
    private final CellLogic CELL_LOGIC;
    public GameController(int width, int height, int seeds){
        this.CELL_LOGIC = new CellLogic(width, height);
        initCells(width, height, seeds);
    }

    public List<ICell> getCellList(){
        return CELL_LOGIC.getAllCells();
    }

    public void updateCellArray(){
        CELL_LOGIC.getAllCells()
                .forEach(iCell -> CELL_LOGIC.setCellStatusArray(iCell.getPOS_X(),
                        iCell.getPOS_Y(), iCell.isAlive()));
    }

    public void setNrOfCellNeighbours(){
        CELL_LOGIC.getAllCells()
                .forEach(CELL_LOGIC::setNrOfCellAliveNeighbours);
    }

    public void updateCells(){
        CELL_LOGIC.getAllCells()
                .forEach(CELL_LOGIC::setCellAliveStatus);
    }

    protected void initCells(int width, int height, int seeds) {
        Random random = new Random();
        for (int i = 0; i < seeds; i++){
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            boolean isAlive = random.nextBoolean();
            CELL_LOGIC.createCell(x, y, isAlive);
            CELL_LOGIC.setCellStatusArray(x, y, isAlive);
        }
    }
}
