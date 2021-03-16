package pers.algorithm.leetcode.bit;

/**
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 */
class GetDecimalValue {

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result <<= 1;
            result += head.val;
            head = head.next;
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode genNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        return head;
    }
}
