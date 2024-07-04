package fht.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testPlaceMarker() {
        board.place(0, 0, 'x');
        assertEquals('x', board.getCells()[0][0]);
    }

    @Test
    public void testIsCellEmpty() {
        assertTrue(board.isCellEmpty(0, 0));
        board.place(0, 0, 'x');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull() {
        char[][] fullBoard = {
                {'x', 'o', 'x'},
                {'x', 'x', 'o'},
                {'o', 'x', 'o'}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, fullBoard[i][j]);
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testClear() {
        board.place(0, 0, 'x');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }
}
