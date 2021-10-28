package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPathSumTest {

    private MinPathSum o;

    @BeforeEach
    void setUp() {
        o = new MinPathSum();
    }

    @Test
    void t1() {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = o.minPathSum(grid);
        assertEquals(7, ans);
    }
}
