package pers.algorithm.leetcode.map;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        Queue<Integer> set = new LinkedList<>();
        int r = 0;
        for (int i = 0; i < isConnected.length; i++) {
            set.add(i);
        }
        while (!set.isEmpty()) {
            Integer e = set.poll();
            traversal(isConnected, e, set);
            r++;
        }
        return r;
    }

    private void traversal(int[][] isConnected, int n, Queue<Integer> set) {
        isConnected[n][n] = 0;
        for (int i = 0; i < isConnected[n].length; i++) {
            if (isConnected[n][i] == 1) {
                isConnected[n][i] = 0;
                isConnected[i][n] = 0;
                set.remove(i);
                traversal(isConnected, i, set);
            }
        }
    }
}
