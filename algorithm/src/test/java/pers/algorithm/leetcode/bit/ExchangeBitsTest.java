package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeBitsTest {

    private final ExchangeBits o = new ExchangeBits();

    @Test
    void test1() {
        assertEquals(1, o.exchangeBits(2));
    }
}
