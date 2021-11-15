package pers.algorithm.leetcode.list;

public class RevertList2 extends RevertList {

    public ListNode revertList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
