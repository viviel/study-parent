package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListIsPalindromeTest {

    private ListIsPalindrome o;

    @BeforeEach
    void setUp() {
        o = new ListIsPalindrome();
    }

    @Test
    void test1() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        Assertions.assertTrue(o.isPalindrome2(l4));
        Assertions.assertFalse(o.isPalindrome2(l3));
    }
}
