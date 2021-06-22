package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostClimbingStairsTest {

    private MinCostClimbingStairs o;

    @BeforeEach
    void setUp() {
        o = new MinCostClimbingStairs();
    }

    @Test
    void test1() {
        int r = o.minCostClimbingStairs(new int[]{10, 15, 20});
        assertEquals(15, r);
    }

    @Test
    void test2() {
        int r = o.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        assertEquals(6, r);
    }
}
