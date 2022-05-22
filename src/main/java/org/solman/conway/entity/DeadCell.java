package org.solman.conway.entity;

import org.solman.conway.cellInterface.ICell;

public class DeadCell extends Cell implements ICell {

    public DeadCell(int POS_X, int POS_Y, boolean isAlive) {
        super(POS_X, POS_Y, isAlive);
    }

    @Override
    public void setAliveStatus() {
        if (nrOfNeighbours == 3){
            setAlive(true);
        }
    }
}
