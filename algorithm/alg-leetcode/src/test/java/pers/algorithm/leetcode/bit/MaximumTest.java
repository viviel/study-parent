package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumTest {

    private final Maximum o = new Maximum();

    @Test
    void test1() {
        assertEquals(2, o.maximum(1, 2));
    }
}
