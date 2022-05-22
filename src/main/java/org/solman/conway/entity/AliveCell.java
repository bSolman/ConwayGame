package org.solman.conway.entity;

import org.solman.conway.cellInterface.ICell;

public class AliveCell implements ICell {
    private boolean isAlive;
    private int nrOfNeighbours = 0;
    private final int POS_X;
    private final int POS_Y;

    public AliveCell(int posX, int posY, boolean isAlive) {
        this.POS_X = posX;
        this.POS_Y = posY;
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getNrOfNeighbours() {
        return nrOfNeighbours;
    }

    public void setNrOfNeighbours(int nrOfNeighbours) {
        this.nrOfNeighbours = nrOfNeighbours;
    }

    @Override
    public void setAliveStatus() {
        if (nrOfNeighbours < 2){
            setAlive(false);
        } else setAlive(nrOfNeighbours <= 3);
    }

    public int getPOS_X() {
        return POS_X;
    }

    public int getPOS_Y() {
        return POS_Y;
    }
}
