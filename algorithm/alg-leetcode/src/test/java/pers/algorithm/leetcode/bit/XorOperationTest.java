package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XorOperationTest {

    private final XorOperation o = new XorOperation();

    @Test
    void test1() {
        assertEquals(8, o.xorOperation(5, 0));
        assertEquals(8, o.xorOperation(4, 3));
    }
}