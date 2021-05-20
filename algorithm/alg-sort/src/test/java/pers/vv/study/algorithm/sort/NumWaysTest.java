package pers.vv.study.algorithm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumWaysTest {

    private final NumWays o = new NumWays();

    @Test
    void test1() {
        assertEquals(1, o.numWays(0));
    }

    @Test
    void test2() {
        assertEquals(21, o.numWays(7));
    }
}
