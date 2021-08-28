package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAbsoluteSumTest {

    private MaxAbsoluteSum o;

    @BeforeEach
    void setUp() {
        o = new MaxAbsoluteSum();
    }

    @Test
    void test1() {
        int[] nums = new int[]{1, -3, 2, 3, -4};
        int ans = o.maxAbsoluteSum(nums);
        assertEquals(5, ans);
    }

    @Test
    void test2() {
        int[] nums = new int[]{2, -5, 1, -4, 3, -2};
        int ans = o.maxAbsoluteSum(nums);
        assertEquals(8, ans);
    }

    @Test
    void test3() {
        int[] nums = new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        int ans = o.maxAbsoluteSum(nums);
        assertEquals(44, ans);
    }

    @Test
    void test4() {
        int[] nums = new int[]{8, -1, -1, -4};
        int ans = o.maxAbsoluteSum(nums);
        assertEquals(8, ans);
    }
}
