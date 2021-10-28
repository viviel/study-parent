package pers.algorithm.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
class MinPathSum {

    public int minPathSum(int[][] grid) {
        return run(grid, grid.length, grid[0].length);
    }

    private int run(int[][] grid, int m, int n) {
        int[][] sum = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    sum[i][j] = grid[i][j];
                } else if (i == m - 1) {
                    sum[i][j] = grid[i][j] + sum[i][j + 1];
                } else if (j == n - 1) {
                    sum[i][j] = grid[i][j] + sum[i + 1][j];
                } else {
                    sum[i][j] = Math.min(grid[i][j] + sum[i + 1][j], grid[i][j] + sum[i][j + 1]);
                }
            }
        }
        return sum[0][0];
    }
}
