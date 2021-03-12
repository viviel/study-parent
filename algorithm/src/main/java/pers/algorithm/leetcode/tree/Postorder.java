package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
class Postorder {

    public List<Integer> postorder(Node root) {
        return Collections.emptyList();
    }

    private void traversal(Node root) {
        if (null == root) {
            return;
        }
        if (null == root.children) {
            return;
        }
        for (Node e : root.children) {
            traversal(e);
        }
        System.out.println(root.val);
    }

    /**
     * 先序 1 3 5 6 2 4
     * 后序 5 6 3 2 4 1
     */
    public List<Integer> postorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node n = s.pop();
            res.add(n.val);
            for (Node node : n.children) {
                s.push(node);
            }
        }
        Collections.reverse(res);
        return res;
    }
}