package pers.algorithm.leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l;
        ListNode r = head;
        int i = 0;
        while (i < n && r.next != null) {
            i++;
            r = r.next;
        }
        if (i != n) {
            return head.next;
        } else {
            l = head;
        }
        while (r.next != null) {
            l = l.next;
            r = r.next;
        }
        if (l.next != null) {
            l.next = l.next.next;
        }
        return head;
    }
}
