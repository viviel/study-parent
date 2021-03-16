package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 案例 1:
 * 输入:
 * |      5
 * |     / \
 * |    3   6
 * |   / \   \
 * |  2   4   7
 * <p>
 * Target = 9
 * <p>
 * 输出: True
 * <p>
 * 案例 2:
 * 输入:
 * |      5
 * |     / \
 * |    3   6
 * |   / \   \
 * |  2   4   7
 * <p>
 * Target = 28
 * <p>
 * 输出: False
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return find(list.toArray(new Integer[0]), k);
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }

    private boolean find(Integer[] arr, int n) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == n) {
                return true;
            } else if (arr[i] + arr[j] < n) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public boolean findTarget2(TreeNode root, int k) {
        return traversal2(root, new HashSet<>(), k);
    }

    private boolean traversal2(TreeNode root, Set<Integer> set, int k) {
        if (null == root) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return traversal2(root.left, set, k) || traversal2(root.right, set, k);
    }
}