package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * |       0
 * |      / \
 * |    -3   9
 * |    /   /
 * |  -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SortedArrayToBST2 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    private TreeNode traversal(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = (l + r) / 2;
        TreeNode t = new TreeNode(nums[m]);
        t.left = traversal(nums, l, m - 1);
        t.right = traversal(nums, m + 1, r);
        return t;
    }
}