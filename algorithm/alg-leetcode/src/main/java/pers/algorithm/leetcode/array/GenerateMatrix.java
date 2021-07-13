package pers.algorithm.leetcode.array;

/**
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 */
class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] r = new int[n][n];
        traversal(r, 0, 1);
        if (n % 2 == 1) {
            int i = n >> 1;
            r[i][i] = n * n;
        }
        return r;
    }

    private void traversal(int[][] a, int m, int start) {
        if (m >= (a.length >> 1)) {
            return;
        }
        for (int i = m; i < a.length - 1 - m; i++) {
            a[m][i] = start++;
        }
        for (int i = m; i < a.length - 1 - m; i++) {
            int raw = a.length - 1 - m;
            a[i][raw] = start++;
        }
        for (int i = a.length - 1 - m; i > m; i--) {
            int raw = a.length - 1 - m;
            a[raw][i] = start++;
        }
        for (int i = a.length - 1 - m; i > m; i--) {
            a[i][m] = start++;
        }
        traversal(a, m + 1, start);
    }
}
