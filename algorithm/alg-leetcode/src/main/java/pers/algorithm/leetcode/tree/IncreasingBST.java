package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 * <p>
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * |         5
 * |        / \
 * |      3    6
 * |     / \    \
 * |    2   4    8
 * |   /        / \
 * |  1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * |  1
 * |   \
 * |    2
 * |     \
 * |      3
 * |       \
 * |        4
 * |         \
 * |          5
 * |           \
 * |            6
 * |             \
 * |              7
 * |               \
 * |                8
 * |                 \
 * |                   9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IncreasingBST {

    private final TreeNode r = new TreeNode();

    private TreeNode ln = r;

    private TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        traversal(root);
        return r.right;
    }

    private void traversal(TreeNode t) {
        if (null == t) {
            return;
        }
        traversal(t.left);
        ln.right = new TreeNode(t.val);
        ln = ln.right;
        traversal(t.right);
    }

    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.right = increasingBST2(root.right);
        if (root.left != null) {
            TreeNode node = root.left;
            root.left = null;
            head = node;
            while (node.right != null) {
                node = node.right;
            }
            node.right = root;
            return increasingBST2(head);
        } else {
            return root;
        }
    }
}