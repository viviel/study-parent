package pers.algorithm.leetcode.structure.link;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.list.ListNode;
import pers.algorithm.leetcode.list.ListNodes;

class ReorderListTest {

    private ReorderList o;

    @BeforeEach
    void setUp() {
        o = new ReorderList2();
    }

    @Test
    void t0() {
        ListNode head = null;
        o.reorderList(head);
    }

    /**
     * 1
     * 1
     */
    @Test
    void t1() {
        ListNode head = ListNodes.listNode(1);
        o.reorderList(head);
    }

    /**
     * 1 2
     * 1 2
     */
    @Test
    void t2() {
        ListNode head = ListNodes.listNode(2);
        o.reorderList(head);
    }

    /**
     * 1 2 3
     * 1 3 2
     */
    @Test
    void t3() {
        ListNode head = ListNodes.listNode(3);
        o.reorderList(head);
    }

    /**
     * 1 2 3 4
     * 1 4 2 3
     */
    @Test
    void t4() {
        ListNode head = ListNodes.listNode(4);
        o.reorderList(head);
    }

    /**
     * 1 2 3 4 5 6 7 8 9
     * 1 9 2 8 3 7 4 6 5
     */
    @Test
    void t9() {
        ListNode head = ListNodes.listNode(9);
        o.reorderList(head);
    }
}
