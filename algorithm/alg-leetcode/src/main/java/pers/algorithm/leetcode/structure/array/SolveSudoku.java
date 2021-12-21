package pers.algorithm.leetcode.structure.array;

class SolveSudoku {

    char[][] row = new char[9][];
    char[][] col = new char[9][];
    char[][][] t = new char[3][3][];

    public void solveSudoku(char[][] board) {
        setup();
        fill(board, 0, 0);
    }

    private void setup() {
        for (int i = 0; i < row.length; i++) {
            row[i] = gen();
        }
        for (int i = 0; i < col.length; i++) {
            col[i] = gen();
        }
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = gen();
            }
        }
    }

    private char[] gen() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    private void fill(char[][] board, int i, int j) {
    }
}
