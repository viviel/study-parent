package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaysToStepTest {

    private WaysToStep o;

    @BeforeEach
    void setUp() {
        o = new WaysToStep();
    }

    @Test
    void test1() {
        int r = o.waysToStep(3);
        assertEquals(4, r);
    }

    @Test
    void test2() {
        int r = o.waysToStep(61);
        assertEquals(752119970, r);
    }
}
