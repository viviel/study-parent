package pers.algorithm.leetcode.structure.link;

import pers.algorithm.leetcode.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
class ReorderList {

    /**
     * O
     */
    public void reorderList(ListNode head) {
        ListNode index = head;
        Deque<ListNode> deque = new LinkedList<>();
        while (index != null) {
            deque.add(index);
            index = index.next;
        }
        ListNode temp = new ListNode(0);
        boolean flag = false;
        while (!deque.isEmpty()) {
            flag = !flag;
            if (flag) {
                temp.next = deque.pollFirst();
            } else {
                temp.next = deque.pollLast();
            }
            temp = temp.next;
        }
        temp.next = null;
    }
}
