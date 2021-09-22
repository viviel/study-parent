package pers.algorithm.leetcode.list;

public class ListNodes {

    public static ListNode listNode(int n) {
        ListNode head = new ListNode(0);
        ListNode t = head;
        for (int i = 0; i < n; i++) {
            t.next = new ListNode(i + 1);
            t = t.next;
        }
        return head.next;
    }
}
