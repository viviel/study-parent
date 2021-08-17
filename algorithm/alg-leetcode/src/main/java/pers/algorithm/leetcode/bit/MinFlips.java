package pers.algorithm.leetcode.bit;

/**
 * https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */
class MinFlips {

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32 && (a != 0 || b != 0 || c != 0); i++) {
            ans += count(a, b, c);
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return ans;
    }

    private int count(int a, int b, int c) {
        int ai = a & 1;
        int bi = b & 1;
        int ci = c & 1;
        if (ci == 1) {
            if (ai == 1 || bi == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (ai == 0 && bi == 0) {
                return 0;
            } else if (ai == 1 && bi == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
