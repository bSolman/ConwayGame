package org.solman.conway.logic;

import org.solman.conway.cellInterface.ICell;
import org.solman.conway.entity.AliveCell;
import org.solman.conway.entity.DeadCell;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CellLogic {
    private final List<ICell> ACTIVE_CELLS = new ArrayList<>();
    private boolean[][] cellStatusArray;

    public CellLogic(int rows, int columns) {
        cellStatusArray = new boolean[rows][columns];
    }

    public void setCellStatusArray(boolean[][] newArray){
        cellStatusArray = newArray;
    }
    public void createCell(int posX, int posY, boolean isAlive){
        if (isAlive){
            ACTIVE_CELLS.add(new AliveCell(posX, posY, true));
        }else {
            ACTIVE_CELLS.add(new DeadCell(posX, posY, false));
        }
    }

    public void setCellStatusArray(int posX, int posY, boolean value) {
        cellStatusArray[posY][posX] = value;
    }

    public List<ICell> getAllCells(){
        return ACTIVE_CELLS;
    }

    public void setCellAliveStatus(ICell cell){
        cell.setAliveStatus();
    }

    public short setNrOfCellAliveNeighbours(@NotNull ICell iCell){
        int startX = setStartPosWithinBorder(iCell.getPOS_X());
        int startY = setStartPosWithinBorder(iCell.getPOS_Y());
        int endX = setEndPosWithinBorderX(iCell.getPOS_X());
        int endY = setEndPosWithinBorderY(iCell.getPOS_Y());
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

    private int setEndPosWithinBorderY(int pos_y) {
        int retVal = pos_y + 1;
        return Math.min(retVal, cellStatusArray.length - 1);
    }

    public int setStartPosWithinBorder(int pos) {
        int retVal = pos - 1;
        return Math.max(retVal, 0);
    }

    public int setEndPosWithinBorderX(int pos) {
        int retVal = pos + 1;
        return Math.min(retVal, cellStatusArray[0].length - 1);
    }
}
