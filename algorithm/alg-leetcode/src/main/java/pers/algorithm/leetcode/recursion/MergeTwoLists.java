package pers.algorithm.leetcode.recursion;

import pers.algorithm.leetcode.tree.search.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
class MergeTwoLists {

    private ListNode n = new ListNode();

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode r = n;
        traversal(l1, l2);
        return r.next;
    }

    private void traversal(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return;
        }
        if (null == l1) {
            n.next = l2;
            return;
        }
        if (null == l2) {
            n.next = l1;
            return;
        }
        if (l1.val <= l2.val) {
            n.next = l1;
            n = n.next;
            traversal(l1.next, l2);
        } else {
            n.next = l2;
            n = n.next;
            traversal(l1, l2.next);
        }
    }
}
