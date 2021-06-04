package pers.algorithm.leetcode.pointer;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ListIsPalindrome {

    public boolean isPalindrome(ListNode head) {
        int[] array = toArray(head);
        return check(array);
    }

    private int[] toArray(ListNode head) {
        return new int[0];
    }

    private boolean check(int[] args) {
        return false;
    }

    /**
     * - 双指针找到链表中点
     * - 反转链表后半部分
     * - 两个链表进行比较
     */
    public boolean isPalindrome2(ListNode head) {
        if (null == head) {
            return true;
        }
        if (null == head.next) {
            return true;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (null != fastNode.next) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (null == fastNode.next) {
                break;
            }
            fastNode = fastNode.next;
        }
        ListNode revert = revertList(slowNode);
        while (null != revert) {
            if (head.val != revert.val) {
                return false;
            }
            head = head.next;
            revert = revert.next;
        }
        return true;
    }

    public ListNode revertList(ListNode node) {
        if (null == node) {
            return null;
        }
        ListNode last = null;
        ListNode current = node;
        ListNode next = node.next;
        while (null != next) {
            current.next = last;
            last = current;
            current = next;
            next = next.next;
        }
        current.next = last;
        return current;
    }

    /**
     * 方法二的优化
     * - 在第一次找中点过程中，直接反转链表前半段
     * - 中点找到后，继续遍历并与前半段的反转后链表比较
     */
    public boolean isPalindrome3(ListNode head) {
        return true;
    }
}
