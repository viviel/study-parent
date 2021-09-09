package pers.algorithm.leetcode.pointer;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class MaxArea {

    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
