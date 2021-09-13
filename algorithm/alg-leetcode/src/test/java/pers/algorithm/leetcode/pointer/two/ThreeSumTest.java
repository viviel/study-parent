package pers.algorithm.leetcode.pointer.two;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTest {

    private ThreeSum o;

    @BeforeEach
    void setUp() {
        o = new ThreeSum();
    }

    /**
     * -1,0,1,2,-1,-4
     * -4, -1, -1, 0, 1, 2
     * <p>
     * [-1,-1,2]
     * [-1,0,1]
     */
    @Test
    void test1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = o.threeSum(nums);
    }

    @Test
    void test2() {
        int[] nums = new int[]{-1};
        List<List<Integer>> ans = o.threeSum(nums);
    }

    @Test
    void test3() {
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> ans = o.threeSum(nums);
    }

    @Test
    void test4() {
        int[] nums = new int[]{-2, 0, 1, 1, 2};
        List<List<Integer>> ans = o.threeSum(nums);
    }
}
