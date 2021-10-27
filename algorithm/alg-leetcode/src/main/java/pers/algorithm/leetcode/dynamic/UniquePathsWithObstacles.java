package pers.algorithm.leetcode.dynamic;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return run(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
    }

    private int run(int[][] obstacleGrid, int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    paths[i][j] = 1;
                } else if (i == m - 1) {
                    paths[i][j] = paths[i][j + 1];
                } else if (j == n - 1) {
                    paths[i][j] = paths[i + 1][j];
                } else {
                    paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
                }
            }
        }
        return paths[0][0];
    }
}
