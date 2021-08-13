package pers.algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/bulb-switcher-iii/
 */
class NumTimesAllBlue2 extends NumTimesAllBlue {

    @Override
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int[] b = new int[light.length + 1];
        Set<Integer> set = new HashSet<>();
        b[0] = 2;
        for (int i : light) {
            if (b[i - 1] == 2) {
                b[i] = 2;
                set.remove(i);
                for (int j = i + 1; j <= light.length && b[j] == 1; j++) {
                    b[j] = 2;
                    set.remove(j);
                }
            } else {
                b[i] = 1;
                set.add(i);
            }
            if (set.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }
}
