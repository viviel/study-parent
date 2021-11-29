package pers.algorithm.leetcode.list;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ansNode = new ListNode(0);
        ListNode leftNode = ansNode;
        leftNode.next = head;
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }
        leftNode.next = revert(leftNode.next, right - left + 1);
        return ansNode.next;
    }

    protected ListNode revert(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode node1 = null;
        ListNode node2 = head;
        for (int i = 0; i < n && node2 != null; i++) {
            ListNode temp = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = temp;
        }
        head.next = node2;
        return node1;
    }
}
