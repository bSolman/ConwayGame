package logic;

import org.solman.conway.entity.AliveCell;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.solman.conway.logic.CellLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(CellLogicResolver.class)
@DisplayName("Test CellLogic class")
class CellLogicTest {

    private final CellLogic CELL_LOGIC = new CellLogic(5, 5);
    private final AliveCell AliveCell = new AliveCell(4,4, true);

    private final boolean[][] TEST_ARRAY = {
            {false, false, false, false, true},
            {false, true, true, true, false},
            {false, true, true, true, false},
            {false, true, true, true, false},
            {false, false, false, false, false}
    };

    @ParameterizedTest
    @CsvFileSource(resources = "/countCell.csv")
    @DisplayName("Count neighbours")
    void countAliveCellNeighbours(int expected, int x, int y) {
        AliveCell aliveCell1 = new AliveCell(x, y, true);
        CELL_LOGIC.setCellStatusArray(TEST_ARRAY);
        assertEquals(expected, CELL_LOGIC.setNrOfCellAliveNeighbours(aliveCell1));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/boundryEnd.csv")
    @DisplayName("Check end boundary")
    void setEndPosWithinBorder(int expected, int x){
        CELL_LOGIC.setCellStatusArray(TEST_ARRAY);
        assertEquals(expected, CELL_LOGIC.setEndPosWithinBorderX(x));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/boundryStart.csv")
    @DisplayName("Check start boundary")
    void setStartPosWithinBorder(int expected, int x){
        CELL_LOGIC.setCellStatusArray(TEST_ARRAY);
        assertEquals(expected, CELL_LOGIC.setStartPosWithinBorder(x));
    }
}