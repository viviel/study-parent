package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Rob2Test {

    private Rob2 o;

    @BeforeEach
    void setUp() {
        o = new Rob2();
    }

    @Test
    void t1() {
        int[] nums = new int[]{2, 3, 2};
        int ans = o.rob(nums);
        assertEquals(3, ans);
    }

    @Test
    void t2() {
        int[] nums = new int[]{1, 2, 3, 1};
        int ans = o.rob(nums);
        assertEquals(4, ans);
    }
}
