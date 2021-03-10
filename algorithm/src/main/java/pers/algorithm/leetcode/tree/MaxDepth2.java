package pers.algorithm.leetcode.tree;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
class MaxDepth2 {

    static class Node {

        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int maxDepth = 0;
        for (Node e : root.children) {
            int depth = maxDepth(e);
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth + 1;
    }
}