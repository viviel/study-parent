package pers.algorithm.leetcode.pointer.two;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class FourSumTest {

    private FourSum o;

    @BeforeEach
    void setUp() {
        o = new FourSum();
    }

    @Test
    void test1() {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> ans = o.fourSum(nums, target);
    }

    @Test
    void test2() {
        int[] nums = new int[]{2, 2, 2, 2, 2};
        int target = 8;
        List<List<Integer>> ans = o.fourSum(nums, target);
    }

    @Test
    void test3() {
        int[] nums = new int[]{-5, 5, 4, -3, 0, 0, 4, -2};
        int target = 4;
        List<List<Integer>> ans = o.fourSum(nums, target);
    }
}
