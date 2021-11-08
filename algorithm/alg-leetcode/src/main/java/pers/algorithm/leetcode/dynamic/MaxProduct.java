package pers.algorithm.leetcode.dynamic;

/**
 * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxProduct {

    public int maxProduct(int[] nums) {
        return r(nums);
    }

    private int r(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int tMax = Math.max(Math.max(max * n, n), min * n);
            int tMin = Math.min(Math.min(max * n, n), min * n);
            max = tMax;
            min = tMin;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
