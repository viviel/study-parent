package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * |    3
 * |   / \
 * |  1   4
 * |   \
 * |   2
 * 输出: 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * |        5
 * |       / \
 * |      3   6
 * |     / \
 * |    2   4
 * |   /
 * |  1
 * 输出: 4
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        Queue<Integer> q = new LinkedList<>();
        traversal(root, k, q);
        if (q.isEmpty()) {
            return 0;
        }
        return q.peek();
    }

    private void traversal(TreeNode root, int k, Queue<Integer> q) {
        if (null == root) {
            return;
        }
        traversal(root.left, k, q);
        if (q.size() == k) {
            q.poll();
        }
        q.add(root.val);
        traversal(root.right, k, q);
    }

    private int r = 0, c = 0;

    public int kthLargest2(TreeNode root, int k) {
        traversal2(root, k);
        return r;
    }

    private void traversal2(TreeNode root, int k) {
        if (null == root) {
            return;
        }
        traversal2(root.right, k);
        if (++c == k) {
            r = root.val;
            return;
        }
        traversal2(root.left, k);
    }
}