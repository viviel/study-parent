package pers.algorithm.leetcode.recursion;

import pers.algorithm.leetcode.list.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 确定思路
 * 初始化快指针边界
 * <p>
 * 解题步骤
 * 再次梳理思路和步骤
 * 测试
 */
class ReverseKGroup {

    private ListNode bound;

    public ListNode reverseKGroup(ListNode head, int k) {
        bound = head;
        for (int i = 0; i < k - 1 && bound != null; i++) {
            bound = bound.next;
        }
        return traversal(null, head, k);
    }

    private ListNode traversal(ListNode pre, ListNode cur, int k) {
        if (bound == null) {
            return cur;
        }
        if (cur == null) {
            return null;
        }
        ListNode tail = cur;
        for (int i = 0; i < k && cur != null; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (bound != null) {
                bound = bound.next;
            }
        }
        tail.next = traversal(pre, cur, k);
        return pre;
    }
}
