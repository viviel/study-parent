package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinOperationsTest {

    private MinOperations o;

    @BeforeEach
    void setUp() {
        o = new MinOperations();
    }

    @Test
    void test1() {
        String[] ss = {"d1/", "d2/", "../", "d21/", "./"};
        assertEquals(2, o.minOperations(ss));
    }

    @Test
    void test2() {
        String[] ss = {"d1/", "../", "../", "../"};
        assertEquals(0, o.minOperations(ss));
    }

}
