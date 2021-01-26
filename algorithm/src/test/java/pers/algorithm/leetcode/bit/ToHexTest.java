package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToHexTest {

    private final ToHex o = new ToHex();

    @Test
    void test1() {
        assertEquals("1a", o.toHex(26));
        assertEquals("ffffffff", o.toHex(-1));
    }
}
