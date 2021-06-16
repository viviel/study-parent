package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitTest {

    private MaxProfit o;

    @BeforeEach
    void setUp() {
        o = new MaxProfit();
    }

    @Test
    void test1() {
        int r = o.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(5, r);
    }
}
