package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    private final MaxProfit o = new MaxProfit();

    @Test
    void test1() {
        assertEquals(7, o.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(13, o.maxProfit(new int[]{7, 1, 5, 3, 6, 4, 10}));
    }

    @Test
    void test2() {
        assertEquals(7, o.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(13, o.maxProfit2(new int[]{7, 1, 5, 3, 6, 4, 10}));
    }
}
