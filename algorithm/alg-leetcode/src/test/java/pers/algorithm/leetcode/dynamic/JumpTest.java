package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpTest {

    private Jump o;

    @BeforeEach
    void setUp() {
        o = new Jump3();
    }

    /**
     * 2, 3, 1, 1, 4
     * 0
     * 1  0
     * 2  1  0
     * 1  2  1  0
     * 2  1  2  1  0
     */
    @Test
    void test1() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int ans = o.jump(nums);
        assertEquals(2, ans);
    }

    @Test
    void test2() {
        int[] nums = new int[]{2, 3, 0, 1, 4};
        int ans = o.jump(nums);
        assertEquals(2, ans);
    }

    @Test
    void test3() {
        int[] nums = new int[]{2, 1};
        int ans = o.jump(nums);
        assertEquals(1, ans);
    }

    @Test
    void test4() {
        int[] nums = new int[]{1, 2, 3};
        int ans = o.jump(nums);
        assertEquals(2, ans);
    }

    @Test
    void test5() {
        int[] nums = new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0};
        int ans = o.jump(nums);
        assertEquals(3, ans);
    }
}
