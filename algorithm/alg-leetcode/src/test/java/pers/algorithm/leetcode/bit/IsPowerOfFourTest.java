package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPowerOfFourTest {

    private final IsPowerOfFour o = new IsPowerOfFour();

    @Test
    void test() {
        assertTrue(o.isPowerOfFour(16));
        assertFalse(o.isPowerOfFour(15));
    }

    @Test
    void test2() {
        assertTrue(o.isPowerOfFour2(16));
        assertFalse(o.isPowerOfFour2(15));
    }
}
