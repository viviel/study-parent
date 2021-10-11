package pers.algorithm.leetcode.list;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        return traversal(head);
    }

    private ListNode traversal(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode n1, n2, n3;
        n1 = node;
        n2 = n1.next;
        if (n2 == null) {
            return n1;
        }
        n3 = n2.next;
        n2.next = n1;
        n1.next = traversal(n3);
        return n2;
    }
}
