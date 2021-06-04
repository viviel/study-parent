package pers.algorithm.leetcode.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RevertListTest {

    private RevertList o;

    @BeforeEach
    void setUp() {
        o = new RevertList();
    }

    @Test
    void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode r = o.revertList(l1);
    }
}
