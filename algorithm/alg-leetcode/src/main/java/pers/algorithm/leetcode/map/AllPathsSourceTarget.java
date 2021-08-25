package pers.algorithm.leetcode.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
class AllPathsSourceTarget {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Stack<Integer> s = new Stack<>();
        s.add(0);
        traversal(graph, 0, s);
        return ans;
    }

    private void traversal(int[][] graph, int i, Stack<Integer> s) {
        if (i >= graph.length) {
            return;
        }
        for (int e : graph[i]) {
            s.push(e);
            if (e == graph.length - 1) {
                ans.add(new ArrayList<>(s));
            } else {
                traversal(graph, e, s);
            }
            s.pop();
        }
    }
}
