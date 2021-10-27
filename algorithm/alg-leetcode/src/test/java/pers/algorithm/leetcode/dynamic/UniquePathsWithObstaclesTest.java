package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsWithObstaclesTest {

    private UniquePathsWithObstacles o;

    @BeforeEach
    void setUp() {
        o = new UniquePathsWithObstacles();
    }

    @Test
    void t1() {
        int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ans = o.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(2, ans);
    }

    @Test
    void t2() {
        int[][] obstacleGrid = new int[][]{{0, 1}, {0, 0}};
        int ans = o.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(1, ans);
    }
}
