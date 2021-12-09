package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagLevelOrder2 extends ZigzagLevelOrder {

    @Override
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return traversal(root);
    }

    private List<List<Integer>> traversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while (!q.isEmpty()) {
            int size = q.size();
            Deque<Integer> l = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left != null) {
                    q.add(poll.left);
                }
                if (poll.right != null) {
                    q.add(poll.right);
                }
                if (flag) {
                    l.addFirst(poll.val);
                } else {
                    l.addLast(poll.val);
                }
            }
            ans.add(new ArrayList<>(l));
            flag = !flag;
        }
        return ans;
    }
}
