package fht.project;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    // Constructor
    public TicTacToe() {
        this.player1 = new Player('x');
        this.player2 = new Player('o');
        this.board = new Board();

        this.currentPlayer = player1;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Current player: " + currentPlayer.getMarker());
            board.print();
            int row = -1;

            while (row < 0 || row > 2) {
                if (sc.hasNextInt()) {
                    row = sc.nextInt();
                } else {
                    sc.next();
                }
            }
            System.out.println("row (0-2): " + row);

            int column = -1;

            while (column < 0 || column > 2) {
                if (sc.hasNextInt()) {
                    column = sc.nextInt();
                } else {
                    sc.next();
                }
            }
            System.out.println("column (0-2): " + column);

            if (board.isCellEmpty(row, column)) {
                board.place(row, column, currentPlayer.getMarker());
                switchCurrentPlayer();
            } else {
                System.out.println("Zelle ist belegt");
            }

        }
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }

    }
}
