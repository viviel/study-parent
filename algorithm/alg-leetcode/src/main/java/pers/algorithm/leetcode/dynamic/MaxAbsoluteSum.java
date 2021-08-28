package pers.algorithm.leetcode.dynamic;

import static java.lang.Math.*;

/**
 * 给你一个整数数组nums。一个子数组[nums_l, nums_l+1, ..., nums_r-1, nums_r]的
 * 和的绝对值为abs(nums_l + nums_l+1 + ... + nums_r-1 + nums_r)。
 * <p>
 * 请你找出 nums中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值。
 * <p>
 * abs(x)定义如下：
 * <p>
 * 如果x是负整数，那么abs(x) = -x。
 * 如果x是非负整数，那么abs(x) = x。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-absolute-sum-of-any-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxAbsoluteSum {

    /**
     * f(i) = max(f(i - 1) + a[i], a[i])
     */
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0;
        int preMax = 0;
        int preMin = 0;
        for (int i : nums) {
            preMax = max(preMax + i, i);
            preMin = min(preMin + i, i);
            ans = max(abs(preMax), ans);
            ans = max(abs(preMin), ans);
        }
        return ans;
    }
}
