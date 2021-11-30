package pers.algorithm.leetcode.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetIntersectionNodeTest {

    private GetIntersectionNode o;

    @BeforeEach
    void setUp() {
        o = new GetIntersectionNode();
    }

    @Test
    void t1() {
        ListNode head = ListNodes.listNode(3);
        int length = o.length(head);
        assertEquals(3, length);
    }

    @Test
    void t2() {
        ListNode share = ListNodes.listNode(3);
        ListNode node5 = new ListNode(5);
        node5.next = share;
        ListNode node6 = new ListNode(6);
        node6.next = share;
        ListNode node7 = new ListNode(7);
        node7.next = node6;
        ListNode ans = o.getIntersectionNode(node5, node7);
    }
}
