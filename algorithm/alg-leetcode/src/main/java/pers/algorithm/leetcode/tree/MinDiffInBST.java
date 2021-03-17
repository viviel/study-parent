package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给定一个二叉搜索树的根节点root，返回树中任意两节点的差的最小值。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * <p>
 * |        4
 * |      /   \
 * |    2      6
 * |   / \
 * |  1   3
 * <p>
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 二叉树的大小范围在 2 到100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinDiffInBST {

    private Integer pre = null, min = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        traversal(root);
        return min;
    }

    private void traversal(TreeNode root) {
        if (null == root) {
            return;
        }
        minDiffInBST(root.left);
        if (null != pre) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        minDiffInBST(root.right);
    }
}