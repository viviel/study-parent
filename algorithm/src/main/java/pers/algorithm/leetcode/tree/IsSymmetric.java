package pers.algorithm.leetcode.tree;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * |      1
 * |     / \
 * |    2   2
 * |   / \ / \
 * |  3  4 4  3
 * <p>
 * <p>
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * |    1
 * |   / \
 * |  2   2
 * |   \   \
 * |   3    3
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left != null && root.right != null) {
            return isSymmetric(root.left, root.right);
        } else {
            return false;
        }
    }

    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l != null && r != null) {
            if (l.val != r.val) {
                return false;
            }
            return isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
        } else {
            return false;
        }
    }
}