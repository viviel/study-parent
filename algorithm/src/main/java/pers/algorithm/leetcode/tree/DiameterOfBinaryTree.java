package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * |      1
 * |     / \
 * |    2   3
 * |   / \
 * |  4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 * <p>
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        return 0;
    }

    private int nodeLength(TreeNode root) {
        int length = 0;
        if (null == root) {
            return 0;
        }
        if (null != root.left) {
            length += maxHeight(root.left) + 1;
        }
        if (null != root.right) {
            length += maxHeight(root.right) + 1;
        }
        return length;
    }

    private int maxHeight(TreeNode root) {
        int count = maxNodeCount(root);
        return Math.max(count - 1, 0);
    }

    private int maxNodeCount(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxNodeCount(root.left), maxNodeCount(root.right)) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        traversal(root);
        return max;
    }

    private int traversal(TreeNode root) {
        if (null == root.left && null == root.right) {
            return 0;
        }
        int leftVal = null == root.left ? 0 : traversal(root.left) + 1;
        int rightVal = null == root.right ? 0: traversal(root.right) + 1;
        max = Math.max(max, leftVal + rightVal);
        return Math.max(leftVal, rightVal);
    }
}
