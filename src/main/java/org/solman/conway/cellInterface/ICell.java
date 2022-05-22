package org.solman.conway.cellInterface;

public interface ICell {
    boolean isAlive();
    int getNrOfNeighbours();
    void setNrOfNeighbours(int nrOfNeighbours);
    void setAliveStatus();

    int getPOS_X();
    int getPOS_Y();
}
