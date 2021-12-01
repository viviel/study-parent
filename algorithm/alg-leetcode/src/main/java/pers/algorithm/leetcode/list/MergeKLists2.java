package pers.algorithm.leetcode.list;

/**
 * 分治
 * <p>
 * O(kn * logk)
 */
class MergeKLists2 extends MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return traversal(lists, 0, lists.length - 1);
    }

    private ListNode traversal(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int split = (l + r) >> 1;
        ListNode list1 = traversal(lists, l, split);
        ListNode list2 = traversal(lists, split + 1, r);
        return merge(list1, list2);
    }
}
