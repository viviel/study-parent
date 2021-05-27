package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrStrTest {

    private final StrStr o = new StrStr();

    @Test
    void test1() {
        assertEquals(2, o.strStr("hello", "ll"));
        assertEquals(3, o.strStr("hello", "lo"));
        assertEquals(-1, o.strStr("hello", "loo"));
    }
}
