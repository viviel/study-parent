package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * |      3
 * |     / \
 * |    4   5
 * |   / \
 * |  1   2
 * 给定的树 t：
 * <p>
 * |    4
 * |   / \
 * |  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 2:
 * 给定的树 s：
 * <p>
 * |      3
 * |     / \
 * |    4   5
 * |   / \
 * |  1   2
 * |     /
 * |    0
 * 给定的树 t：
 * <p>
 * |    4
 * |   / \
 * |  1   2
 * 返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (null == s || null == t) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}