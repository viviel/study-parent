package pers.algorithm.leetcode.structure.link;

import pers.algorithm.leetcode.list.ListNode;

class ReorderList2 extends ReorderList {

    @Override
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode midNode = mid(head);
        ListNode l2 = midNode.next;
        midNode.next = null;
        l2 = reverse(l2);
        merge(head, l2);
    }

    private ListNode mid(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (two.next != null && two.next.next != null) {
            two = two.next.next;
            one = one.next;
        }
        return one;
    }

    private ListNode reverse(ListNode head) {
        ListNode left = null;
        ListNode right = head;
        while (right != null) {
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        return left;
    }

    private void merge(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            ListNode l1 = list1.next;
            ListNode l2 = list2.next;
            list1.next = list2;
            list1 = l1;
            list2.next = list1;
            list2 = l2;
        }
    }
}
