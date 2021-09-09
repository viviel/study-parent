package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAreaTest {

    private MaxArea o;

    @BeforeEach
    void setUp() {
        o = new MaxArea2();
    }

    @Test
    void test1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = o.maxArea(height);
        assertEquals(49, ans);
    }

    @Test
    void test2() {
        int[] height = new int[]{1, 1};
        int ans = o.maxArea(height);
        assertEquals(1, ans);
    }

    @Test
    void test3() {
        int[] height = new int[]{4, 3, 2, 1, 4};
        int ans = o.maxArea(height);
        assertEquals(16, ans);
    }

    @Test
    void test4() {
        int[] height = new int[]{1, 2, 1};
        int ans = o.maxArea(height);
        assertEquals(2, ans);
    }
}
