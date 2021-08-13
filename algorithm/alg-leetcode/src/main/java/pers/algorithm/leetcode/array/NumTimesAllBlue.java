package pers.algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bulb-switcher-iii/
 */
class NumTimesAllBlue {

    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int[] b = new int[light.length + 1];
        b[0] = 2;
        for (int i : light) {
            if (b[i - 1] == 2) {
                b[i] = 2;
                for (int j = i + 1; j <= light.length && b[j] == 1; j++) {
                    b[j] = 2;
                }
            } else {
                b[i] = 1;
            }
            ans++;
            for (int k : b) {
                if (k == 1) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
