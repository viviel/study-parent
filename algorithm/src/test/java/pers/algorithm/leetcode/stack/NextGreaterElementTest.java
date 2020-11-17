package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.stack.NextGreaterElement;

class NextGreaterElementTest {

    @Test
    void test1() {
        NextGreaterElement o = new NextGreaterElement();
        int[] p1 = {4, 1, 2};
        int[] p2 = {1, 3, 4, 2};
        int[] r = {-1, 3, -1};
        Assertions.assertArrayEquals(o.nextGreaterElement(p1, p2), r);
    }

    /**
     * [2,4]
     * [1,2,3,4]
     * [3,-1]
     */
    @Test
    void test2() {
        NextGreaterElement o = new NextGreaterElement();
        int[] p1 = {2, 4};
        int[] p2 = {1, 2, 3, 4};
        int[] r = {3, -1};
        Assertions.assertArrayEquals(o.nextGreaterElement(p1, p2), r);
    }

}
