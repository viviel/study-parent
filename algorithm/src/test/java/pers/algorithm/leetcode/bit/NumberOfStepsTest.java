package pers.algorithm.leetcode.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfStepsTest {

    private final NumberOfSteps o = new NumberOfSteps();

    @Test
    void test1() {
        assertEquals(6, o.numberOfSteps(14));
        assertEquals(4, o.numberOfSteps(8));
    }
}
