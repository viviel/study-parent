package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestPerimeterTest {

    private final LargestPerimeter o = new LargestPerimeter();

    @Test
    void test1() {
        assertEquals(8, o.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}