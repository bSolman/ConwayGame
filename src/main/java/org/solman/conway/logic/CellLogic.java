package org.solman.conway.logic;

import org.solman.conway.cellInterface.ICell;
import org.solman.conway.entity.AliveCell;
import org.solman.conway.entity.DeadCell;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CellLogic {
    private final List<ICell> CELLS_ALIVE = new ArrayList<>();
    private boolean[][] cellStatusArray;

    public CellLogic(int rows, int columns) {
        cellStatusArray = new boolean[rows][columns];
    }

    public void setCellStatusArray(boolean[][] newArray){
        cellStatusArray = newArray;
    }
    public void createCell(int posX, int posY, boolean isAlive){
        if (isAlive){
            CELLS_ALIVE.add(new AliveCell(posX, posY, true));
        }else {
            CELLS_ALIVE.add(new DeadCell(posX, posY, false));
        }
    }

    public void setCellStatusArray(int posX, int posY, boolean value) {
        cellStatusArray[posX][posY] = value;
    }

    public List<ICell> getAllCells(){
        return CELLS_ALIVE;
    }

    public void setCellAliveStatus(ICell cell){
        cell.setAliveStatus();
    }

    public short setNrOfCellAliveNeighbours(@NotNull ICell iCell){
        int startX = setStartPosWithinBorder(iCell.getPOS_X());
        int startY = setStartPosWithinBorder(iCell.getPOS_Y());
        int endX = setEndPosWithinBorder(iCell.getPOS_X());
        int endY = setEndPosWithinBorder(iCell.getPOS_Y());
        short count = 0;

        for (int i = startY; i <= endY; i++){
            for (int j = startX; j <= endX; j++){
                if (i == iCell.getPOS_Y() && j == iCell.getPOS_X()){
                    continue;
                }
                if (cellStatusArray[i][j]){
                    count++;
                }
            }
        }
        iCell.setNrOfNeighbours(count);
        return count;
    }

    public int setStartPosWithinBorder(int pos) {
        int retVal = pos - 1;
        return Math.max(retVal, 0);
    }

    public int setEndPosWithinBorder(int pos) {
        int retVal = pos + 1;
        return Math.min(retVal, cellStatusArray[0].length - 1);
    }
}
