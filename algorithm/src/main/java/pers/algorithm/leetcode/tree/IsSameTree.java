package pers.algorithm.leetcode.tree;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例1:
 * <p>
 * 输入:       1         1
 * |         / \       / \
 * |        2   3     2   3
 * <p>
 * |       [1,2,3],   [1,2,3]
 * <p>
 * 输出: true
 * <p>
 * 示例 2:
 * <p>
 * 输入:      1          1
 * |         /           \
 * |        2             2
 * <p>
 * |       [1,2],     [1,null,2]
 * <p>
 * 输出: false
 * <p>
 * 示例3:
 * <p>
 * 输入:       1         1
 * |         / \       / \
 * |        2   1     1   2
 * <p>
 * |       [1,2,1],   [1,1,2]
 * <p>
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }
}