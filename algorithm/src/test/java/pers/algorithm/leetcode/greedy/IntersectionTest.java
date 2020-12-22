package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionTest {

    private final Intersection o = new Intersection();

    @Test
    void test1() {
        assertArrayEquals(new int[]{2}, o.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
//        assertArrayEquals(new int[]{9, 4}, o.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    @Test
    void test2() {
        assertArrayEquals(new int[]{2}, o.intersection2(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
//        assertArrayEquals(new int[]{9, 4}, o.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

    @Test
    void test3() {
        assertArrayEquals(new int[]{2}, o.intersection3(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
//        assertArrayEquals(new int[]{9, 4}, o.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}