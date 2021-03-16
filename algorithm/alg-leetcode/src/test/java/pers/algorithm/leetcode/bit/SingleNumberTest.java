package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

    private final SingleNumber o = new SingleNumber();

    @Test
    void test1() {
        assertEquals(1, o.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, o.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}