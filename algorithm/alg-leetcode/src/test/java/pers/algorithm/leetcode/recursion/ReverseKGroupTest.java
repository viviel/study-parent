package pers.algorithm.leetcode.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.algorithm.leetcode.list.ListNode;
import pers.algorithm.leetcode.list.ListNodes;

class ReverseKGroupTest {

    private ReverseKGroup o;

    @BeforeEach
    void setUp() {
        o = new ReverseKGroup();
    }

    /**
     * 0 -> 1 -> 2 -> 3 -> 4 -> 5
     * 0 -> 1    2 -> 3 -> 4 -> 5
     * 0 -> 1 <- 2    3 -> 4 -> 5
     * <p>
     * 0 -> 1 <- 2 <- 3 <- 4    5
     */
    @Test
    void t1() {
        ListNode listNode = ListNodes.listNode(5);
        ListNode ans = o.reverseKGroup(listNode, 3);
    }

    @Test
    void t2() {
        ListNode listNode = ListNodes.listNode(5);
        ListNode ans = o.reverseKGroup(listNode, 2);
    }
}
