package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetDecimalValueTest {

    private final GetDecimalValue o = new GetDecimalValue();

    @Test
    void test1() {
        assertEquals(5, o.getDecimalValue(o.genNode()));
    }
}