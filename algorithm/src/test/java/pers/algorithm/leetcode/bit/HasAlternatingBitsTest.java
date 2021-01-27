package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasAlternatingBitsTest {

    private final HasAlternatingBits o = new HasAlternatingBits();

    @Test
    void test1() {
        assertTrue(o.hasAlternatingBits(5));
        assertFalse(o.hasAlternatingBits(7));
    }
}
