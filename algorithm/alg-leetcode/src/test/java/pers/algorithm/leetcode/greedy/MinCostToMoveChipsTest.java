package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinCostToMoveChipsTest {

    private final MinCostToMoveChips o = new MinCostToMoveChips();

    @Test
    void test1() {
        assertEquals(1, o.minCostToMoveChips(new int[]{1, 2, 3}));
        assertEquals(2, o.minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }
}