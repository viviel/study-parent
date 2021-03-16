package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestSumAfterKNegationsTest {

    private final LargestSumAfterKNegations o = new LargestSumAfterKNegations();

    @Test
    void test1() {
        assertEquals(5, o.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        assertEquals(6, o.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
    }

    @Test
    void test2() {
        assertEquals(5, o.largestSumAfterKNegations2(new int[]{4, 2, 3}, 1));
        assertEquals(6, o.largestSumAfterKNegations2(new int[]{3, -1, 0, 2}, 3));
    }
}