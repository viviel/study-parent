package pers.algorithm.leetcode.tree;

import pers.algorithm.leetcode.tree.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(Node root, List<Integer> result) {
        if (null == root) {
            return;
        }
        result.add(root.val);
        if (null == root.children) {
            return;
        }
        for (Node e : root.children) {
            traversal(e, result);
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            Node node = s.pop();
            result.add(node.val);
            if (null == node.children) {
                continue;
            }
            for (int i = node.children.size() - 1; i >= 0; i--) {
                s.push(node.children.get(i));
            }
        }
        return result;
    }
}