package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 * <p>
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * | [
 * |   [3],
 * |   [20,9],
 * |   [15,7]
 * | ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ZigzagLevelOrder {

    /**
     * 分析
     * 先实现按层遍历
     * 再实现锯齿遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return traversal(root);
    }

    private List<List<Integer>> traversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> left2right = new LinkedList<>();
        left2right.add(root);
        Queue<TreeNode> right2left = new LinkedList<>();
        right2left.add(root);
        boolean flag = true;
        while (!left2right.isEmpty()) {
            int size = left2right.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = left2right.poll();
                if (poll.left != null) {
                    left2right.add(poll.left);
                }
                if (poll.right != null) {
                    left2right.add(poll.right);
                }
                TreeNode poll2 = right2left.poll();
                if (poll2.right != null) {
                    right2left.add(poll2.right);
                }
                if (poll2.left != null) {
                    right2left.add(poll2.left);
                }
                if (flag) {
                    l.add(poll.val);
                } else {
                    l.add(poll2.val);
                }
            }
            ans.add(l);
            flag = !flag;
        }
        return ans;
    }
}
