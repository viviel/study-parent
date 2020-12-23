package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectTest {

    private final Intersect o = new Intersect();

    @Test
    void test1() {
        assertArrayEquals(new int[]{2, 2}, o.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }
}