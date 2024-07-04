package fht.project;

public class Board {
    private char[][] cells;

    public Board() {
        this.cells = new char[3][3];
    }

    public void place(int x, int y, char marker) {

    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\u0000';
    }

}
