package pers.algorithm.leetcode.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveNthFromEndTest {

    private RemoveNthFromEnd o;

    @BeforeEach
    void setUp() {
        o = new RemoveNthFromEnd();
    }

    /**
     * |
     * 1 2 3 4 5 6 7
     */
    @Test
    void test1() {
        ListNode listNode = ListNodes.listNode(5);
    }

    /**
     * |
     * 1 2 3
     */
    @Test
    void test2() {
        ListNode head = ListNodes.listNode(5);
        ListNode r = o.removeNthFromEnd(head, 2);
    }

    @Test
    void test3() {
        ListNode head = ListNodes.listNode(2);
        ListNode r = o.removeNthFromEnd(head, 3);
    }
}
