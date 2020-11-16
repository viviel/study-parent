package pers.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalPointsTest {

    private final CalPoints o = new CalPoints();

    @Test
    void test1() {
        String[] p = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        assertEquals(o.calPoints(p), 27);
    }

}