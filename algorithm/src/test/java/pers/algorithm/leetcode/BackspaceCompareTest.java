package pers.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackspaceCompareTest {

    private final BackspaceCompare o = new BackspaceCompare();

    @Test
    void test1() {
        assertTrue(o.backspaceCompare1("ab#c", "ad#c"));
        assertFalse(o.backspaceCompare1("a#c", "b"));
    }

    @Test
    void test2() {
        assertTrue(o.backspaceCompare2("ab#c", "ad#c"));
        assertFalse(o.backspaceCompare2("##a####", "b"));
    }

}
