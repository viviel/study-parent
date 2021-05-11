package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 * <p>
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * 返回其层次遍历结果：
 * <p>
 * |  [
 * |    [3],
 * |    [9,20],
 * |    [15,7]
 * |  ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                l.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            r.add(l);
        }
        return r;
    }
}