package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPowerOfTwoTest {

    private final IsPowerOfTwo o = new IsPowerOfTwo();

    @Test
    void test1() {
        assertTrue(o.isPowerOfTwo(1));
        assertTrue(o.isPowerOfTwo(16));
        assertFalse(o.isPowerOfTwo(17));
    }

    @Test
    void test2() {
        assertTrue(o.isPowerOfTwo2(1));
        assertTrue(o.isPowerOfTwo2(16));
        assertFalse(o.isPowerOfTwo2(17));
    }
}