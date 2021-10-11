package pers.algorithm.leetcode.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SwapPairsTest {

    private SwapPairs o;

    @BeforeEach
    void setUp() {
        o = new SwapPairs();
    }

    @Test
    void test1() {
        ListNode ans = o.swapPairs(ListNodes.listNode(0));
    }

    @Test
    void test2() {
        ListNode ans = o.swapPairs(ListNodes.listNode(1));
    }

    @Test
    void test3() {
        ListNode ans = o.swapPairs(ListNodes.listNode(2));
    }

    @Test
    void test4() {
        ListNode ans = o.swapPairs(ListNodes.listNode(4));
    }

    @Test
    void test5() {
        ListNode ans = o.swapPairs(ListNodes.listNode(5));
    }
}
