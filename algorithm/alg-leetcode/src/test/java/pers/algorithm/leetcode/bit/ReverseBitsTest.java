package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseBitsTest {

    private ReverseBits o = new ReverseBits();

    @Test
    void test1() {
        assertEquals(964176192, o.reverseBits(43261596));
    }
}