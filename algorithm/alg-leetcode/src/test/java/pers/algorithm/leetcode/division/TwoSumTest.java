package pers.algorithm.leetcode.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private final TwoSum o = new TwoSum();

    @Test
    void test1() {
        assertArrayEquals(new int[]{1, 2}, o.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, o.twoSum(new int[]{2, 3, 4}, 6));
    }
}