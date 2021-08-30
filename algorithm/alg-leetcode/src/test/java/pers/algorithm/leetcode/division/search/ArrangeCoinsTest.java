package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrangeCoinsTest {

    private final ArrangeCoins o = new ArrangeCoins();

    @Test
    void test1() {
        assertEquals(2, o.arrangeCoins(5));
        assertEquals(3, o.arrangeCoins(8));
        assertEquals(65535, o.arrangeCoins(2147483647));
    }
}