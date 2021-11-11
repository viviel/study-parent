package pers.algorithm.leetcode.dynamic;

class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        return run(matrix);
    }

    private int run(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int ans = 0;
        int[][] c = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    c[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = Math.min(Math.min(c[i - 1][j - 1], c[i - 1][j]), c[i][j - 1]) + 1;
                }
                ans = Math.max(ans, c[i][j]);
            }
        }
        return ans * ans;
    }
}
