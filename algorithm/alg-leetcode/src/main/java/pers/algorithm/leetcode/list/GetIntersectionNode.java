package pers.algorithm.leetcode.list;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA > lengthB) {
            int i = lengthA - lengthB;
            for (int j = 0; j < i; j++) {
                headA = headA.next;
            }
        } else {
            int i = lengthB - lengthA;
            for (int j = 0; j < i; j++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    protected int length(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans++;
            head = head.next;
        }
        return ans;
    }
}
