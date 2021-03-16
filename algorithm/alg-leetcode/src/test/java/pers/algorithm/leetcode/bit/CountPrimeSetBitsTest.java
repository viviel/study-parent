package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountPrimeSetBitsTest {

    private final CountPrimeSetBits o = new CountPrimeSetBits();

    @Test
    void test1() {
        assertEquals(4, o.countPrimeSetBits(6, 10));
        assertEquals(5, o.countPrimeSetBits(10, 15));
    }

    @Test
    void test2() {
        assertEquals(4, o.countPrimeSetBits2(6, 10));
        assertEquals(5, o.countPrimeSetBits2(10, 15));
    }

    @Test
    void test3() {
        assertEquals(4, o.countPrimeSetBits3(6, 10));
        assertEquals(5, o.countPrimeSetBits3(10, 15));
    }
}