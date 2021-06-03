package pers.algorithm.leetcode.pointer;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fl = head;
        ListNode sl = head;
        while (true) {
            if (null == fl) {
                return false;
            }
//            for (int i = 0; i < 2; i++) {
//                fl = fl.next;
//                if (null == fl) {
//                    return false;
//                } else if (fl == sl) {
//                    return true;
//                }
//            }
            fl = fl.next;
            if (null == fl) {
                return false;
            }
            fl = fl.next;
            if (fl == sl) {
                return true;
            }
            sl = sl.next;
        }
    }
}
