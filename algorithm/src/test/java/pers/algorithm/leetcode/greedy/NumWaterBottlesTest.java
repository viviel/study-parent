package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumWaterBottlesTest {

    private final NumWaterBottles o = new NumWaterBottles();

    @Test
    void test1() {
        assertEquals(13, o.numWaterBottles(9, 3));
        assertEquals(19, o.numWaterBottles(15, 4));
    }
}