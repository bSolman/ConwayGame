package org.solman.conway.entity;

import org.solman.conway.cellInterface.ICell;

public class AliveCell extends Cell implements ICell {

    public AliveCell(int POS_X, int POS_Y, boolean isAlive) {
        super(POS_X, POS_Y, isAlive);
    }

    @Override
    public void setAliveStatus() {
        if (nrOfNeighbours < 2){
            setAlive(false);
        } else setAlive(nrOfNeighbours <= 3);
    }
}
