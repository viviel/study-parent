package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProductTest {

    private MaxProduct o;

    @BeforeEach
    void setUp() {
        o = new MaxProduct();
    }

    /**
     * 2,3,-2,4
     * 2,6,
     * 2,3
     */
    @Test
    void t1() {
        int[] nums = new int[]{2, 3, -2, 4};
        int ans = o.maxProduct(nums);
        assertEquals(6, ans);
    }

    /**
     * -2,0,-1
     */
    @Test
    void t2() {
        int[] nums = new int[]{-2, 0, -1};
        int ans = o.maxProduct(nums);
        assertEquals(0, ans);
    }

    /**
     * 2, 3, -2,  4, -1
     * 2, 6, -2,  4, 48
     * 2, 3,-12,-48, -4
     */
    @Test
    void t3() {
        int[] nums = new int[]{2, 3, -2, 4, -1};
        int ans = o.maxProduct(nums);
        assertEquals(48, ans);
    }

    @Test
    void t4() {
        int[] nums = new int[]{-2};
        int ans = o.maxProduct(nums);
        assertEquals(-2, ans);
    }
}
