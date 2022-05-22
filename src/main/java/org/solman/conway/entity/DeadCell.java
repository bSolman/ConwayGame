package org.solman.conway.entity;

import org.solman.conway.cellInterface.ICell;

public class DeadCell implements ICell {
    private boolean isAlive;
    private int nrOfNeighbours = 0;
    private final int POS_X;
    private final int POS_Y;

    public DeadCell(int posX, int posY, boolean isAlive) {
        this.POS_X = posX;
        this.POS_Y = posY;
        this.isAlive = isAlive;
    }

    public int getPOS_X() {
        return POS_X;
    }

    public int getPOS_Y() {
        return POS_Y;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public int getNrOfNeighbours() {
        return nrOfNeighbours;
    }

    @Override
    public void setNrOfNeighbours(int nrOfNeighbours) {
        this.nrOfNeighbours = nrOfNeighbours;
    }

    @Override
    public void setAliveStatus() {
        if (nrOfNeighbours == 3){
            isAlive = true;
        }
    }
}
