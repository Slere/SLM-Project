package fht.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testInitialCurrentPlayer() throws Exception {
        Field currentPlayerField = TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        Player currentPlayer = (Player) currentPlayerField.get(game);
        assertEquals('x', currentPlayer.getMarker());
    }

    @Test
    public void testSwitchCurrentPlayer() throws Exception {
        Method switchCurrentPlayerMethod = TicTacToe.class.getDeclaredMethod("switchCurrentPlayer");
        switchCurrentPlayerMethod.setAccessible(true);
        switchCurrentPlayerMethod.invoke(game);

        Field currentPlayerField = TicTacToe.class.getDeclaredField("currentPlayer");
        currentPlayerField.setAccessible(true);
        Player currentPlayer = (Player) currentPlayerField.get(game);
        assertEquals('o', currentPlayer.getMarker());
    }

    @Test
    public void testHasWinnerRow() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0, 0, 'x');
        board.place(0, 1, 'x');
        board.place(0, 2, 'x');

        Method hasWinnerMethod = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinnerMethod.setAccessible(true);
        boolean hasWinner = (boolean) hasWinnerMethod.invoke(game);

        assertTrue(hasWinner);
    }

    @Test
    public void testHasWinnerColumn() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0, 0, 'o');
        board.place(1, 0, 'o');
        board.place(2, 0, 'o');

        Method hasWinnerMethod = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinnerMethod.setAccessible(true);
        boolean hasWinner = (boolean) hasWinnerMethod.invoke(game);

        assertTrue(hasWinner);
    }

    @Test
    public void testHasWinnerDiagonal() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        board.place(0, 0, 'x');
        board.place(1, 1, 'x');
        board.place(2, 2, 'x');

        Method hasWinnerMethod = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinnerMethod.setAccessible(true);
        boolean hasWinner = (boolean) hasWinnerMethod.invoke(game);

        assertTrue(hasWinner);
    }

    @Test
    public void testIsDraw() throws Exception {
        Field boardField = TicTacToe.class.getDeclaredField("board");
        boardField.setAccessible(true);
        Board board = (Board) boardField.get(game);

        char[][] drawBoard = {
                {'x', 'o', 'x'},
                {'x', 'x', 'o'},
                {'o', 'x', 'o'}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, drawBoard[i][j]);
            }
        }

        Method isFullMethod = Board.class.getDeclaredMethod("isFull");
        isFullMethod.setAccessible(true);
        boolean isFull = (boolean) isFullMethod.invoke(board);

        Method hasWinnerMethod = TicTacToe.class.getDeclaredMethod("hasWinner");
        hasWinnerMethod.setAccessible(true);
        boolean hasWinner = (boolean) hasWinnerMethod.invoke(game);

        assertTrue(isFull);
        assertFalse(hasWinner);
    }
}
