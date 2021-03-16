package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * |     1
 * |   /   \
 * |  2     3
 * |   \
 * |    5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        treePath(root, new StringBuffer(), result);
        return result;
    }

    private void treePath(TreeNode root, StringBuffer path, List<String> result) {
        if (null == root) {
            return;
        }
        path.append(root.val);
        if (null == root.left && null == root.right) {
            result.add(path.toString());
        } else {
            path.append("->");
            treePath(root.left, new StringBuffer(path), result);
            treePath(root.right, new StringBuffer(path), result);
        }
    }
}
