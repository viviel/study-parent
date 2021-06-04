package pers.algorithm.leetcode.list;

public class RevertList {

    /**
     * 1->2->3->4->5->6
     */
    public ListNode revertList(ListNode node) {
        if (null == node) {
            return null;
        }
        ListNode last = null;
        ListNode current = node;
        ListNode next = node.next;
        while (null != next) {
            current.next = last;
            last = current;
            current = next;
            next = next.next;
        }
        current.next = last;
        return current;
    }
}
