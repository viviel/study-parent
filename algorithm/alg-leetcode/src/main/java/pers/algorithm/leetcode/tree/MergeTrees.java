package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * |  Tree 1                     Tree 2
 * |      1                        2
 * |     / \                      / \
 * |    3   2                    1   3
 * |   /                          \   \
 * |  5                            4   7
 * 输出:
 * 合并后的树:
 * |      3
 * |     / \
 * |    4   5
 * |   / \   \
 * |  5   4   7
 * 注意:合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MergeTrees {

    /**
     * 能否改变入参数据结构
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null != root2) {
            root1.val += root2.val;
        }
        traversal(root1, root2);
        return root1;
    }

    private void traversal(TreeNode t1, TreeNode t2) {
        if (null == t1 || null == t2) {
            return;
        }
        if (null != t1.left && null != t2.left) {
            t1.left.val += t2.left.val;
        }
        if (null != t1.right && null != t2.right) {
            t1.right.val += t2.right.val;
        }
        if (null == t1.left && null != t2.left) {
            t1.left = new TreeNode(t2.left.val);
        }
        if (null == t1.right && null != t2.right) {
            t1.right = new TreeNode(t2.right.val);
        }
        traversal(t1.left, t2.left);
        traversal(t1.right, t2.right);
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (null == root1 && null == root2) {
            return null;
        }
        TreeNode node = new TreeNode((null == root1 ? 0 : root1.val) + (null == root2 ? 0 : root2.val));
        node.left = mergeTrees2(null == root1 ? null : root1.left, null == root2 ? null : root2.left);
        node.right = mergeTrees2(null == root1 ? null : root1.right, null == root2 ? null : root2.right);
        return node;
    }
}