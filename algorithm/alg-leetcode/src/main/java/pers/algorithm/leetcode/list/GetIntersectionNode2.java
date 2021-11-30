package pers.algorithm.leetcode.list;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode2 {

    /**
     * 相交
     * lengthA = a + c
     * lengthB = b + c
     * a + c + b = b + c + a
     * <p>
     * 不相交
     * lengthA = a
     * lengthB = b
     * a + b = b + a
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
