package pers.algorithm.leetcode.pointer;

import static java.lang.Math.*;

class MaxArea2 extends MaxArea {

    /**
     * 双指针
     */
    @Override
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int temp = (j - i) * min(height[i], height[j]);
            ans = max(ans, temp);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
