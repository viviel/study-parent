package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * |  1
 * |   \
 * |    3
 * |   /
 * |  2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GetMinimumDifference {

    private int lastVal = -1;
    private int minVal = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return minVal;
    }

    private void traversal(TreeNode root) {
        if (null == root) {
            return;
        }
        traversal(root.left);
        if (lastVal < 0) {
            lastVal = root.val;
        } else {
            minVal = Math.min(minVal, root.val - lastVal);
            lastVal = root.val;
        }
        traversal(root.right);
    }
}