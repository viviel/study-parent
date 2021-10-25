package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CanJumpTest {

    private CanJump o;

    @BeforeEach
    void setUp() {
        o = new CanJump();
    }

    /**
     * 0  1  2  3  4
     * 2, 3, 1, 1, 4
     */
    @Test
    void t1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean ans = o.canJump(nums);
        assertTrue(ans);
    }

    /**
     * 0  1  2  3  4
     * 3, 2, 1, 0, 4
     */
    @Test
    void t2() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean ans = o.canJump(nums);
        assertFalse(ans);
    }

    @Test
    void t3() {
        int[] nums = {3, 20, 1, 0, 4};
        boolean ans = o.canJump(nums);
        assertTrue(ans);
    }

    @Test
    void t4() {
        int[] nums = {30, 2, 1, 0, 4};
        boolean ans = o.canJump(nums);
        assertTrue(ans);
    }
}
