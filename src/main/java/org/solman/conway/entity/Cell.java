package org.solman.conway.entity;

import org.solman.conway.cellInterface.ICell;

public abstract class Cell{
    private final int POS_X;
    private final int POS_Y;
    private boolean isAlive;
    int nrOfNeighbours = 0;

    public Cell(int POS_X, int POS_Y, boolean isAlive) {
        this.POS_X = POS_X;
        this.POS_Y = POS_Y;
        this.isAlive = isAlive;
    }

    public int getPOS_X() {
        return POS_X;
    }

    public int getPOS_Y() {
        return POS_Y;
    }

    public int getNrOfNeighbours() {
        return nrOfNeighbours;
    }

    public void setNrOfNeighbours(int nrOfNeighbours) {
        this.nrOfNeighbours = nrOfNeighbours;
    }

    public void setAlive(boolean isAlive){
        this.isAlive = isAlive;
    }

    public boolean isAlive(){
        return this.isAlive;
    }
}
