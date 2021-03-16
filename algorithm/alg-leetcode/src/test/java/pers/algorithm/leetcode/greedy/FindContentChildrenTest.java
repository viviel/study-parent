package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindContentChildrenTest {

    private final FindContentChildren o = new FindContentChildren();

    @Test
    void test1() {
        assertEquals(1, o.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        assertEquals(2, o.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    @Test
    void test2() {
        assertEquals(1, o.findContentChildren2(new int[]{1, 2, 3}, new int[]{1, 1}));
        assertEquals(2, o.findContentChildren2(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
