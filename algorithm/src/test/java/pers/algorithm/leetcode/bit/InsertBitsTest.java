package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertBitsTest {

    private final InsertBits o = new InsertBits();

    @Test
    void test1() {
        assertEquals(1100, o.insertBits(1024, 19, 2, 6));
        assertEquals(31, o.insertBits(0, 31, 0, 4));
        assertEquals(1243714409, o.insertBits(2032243561, 10, 24, 29));
    }
}
