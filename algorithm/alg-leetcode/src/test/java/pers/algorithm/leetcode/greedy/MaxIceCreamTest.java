package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxIceCreamTest {

    private MaxIceCream o;

    @BeforeEach
    void setUp() {
        o = new MaxIceCream();
    }

    @Test
    void test1() {
        int[] costs = new int[]{1, 3, 2, 4, 1};
        int ans = o.maxIceCream(costs, 7);
        assertEquals(4, ans);
    }

    @Test
    void test2() {
        int[] costs = new int[]{1, 6, 3, 1, 2, 5};
        int ans = o.maxIceCream(costs, 20);
        assertEquals(6, ans);
    }

    @Test
    void test3() {
        int[] costs = new int[]{10, 6, 8, 7, 7, 8};
        int ans = o.maxIceCream(costs, 5);
        assertEquals(0, ans);
    }
}
