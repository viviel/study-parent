package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertIntegerTest {

    private final ConvertInteger o = new ConvertInteger();

    @Test
    void test1() {
        assertEquals(2, o.convertInteger(29, 15));
    }
}
