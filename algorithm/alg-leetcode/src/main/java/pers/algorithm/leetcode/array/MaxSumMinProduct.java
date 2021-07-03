package pers.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 一个数组的 最小乘积定义为这个数组中 最小值乘以数组的 和。
 * <p>
 * 比方说，数组[3,2,5]（最小值是2）的最小乘积为2 * (3+2+5) = 2 * 10 = 20。
 * 给你一个正整数数组nums，请你返回nums任意非空子数组的最小乘积的最大值。由于答案可能很大，请你返回答案对10^9 + 7取余的结果。
 * <p>
 * 请注意，最小乘积的最大值考虑的是取余操作 之前的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数保存。
 * <p>
 * 子数组定义为一个数组的 连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-min-product
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxSumMinProduct {

    /**
     * 解答错误
     * 不能打乱数组顺序，即不能排序
     */
    public int maxSumMinProduct(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, r = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum = sum + nums[i];
            if (nums[i] * sum > r) {
                r = nums[i] * sum;
            } else {
                break;
            }
        }
        return (int) (r % 1000000007);
    }

    /**
     * 核心思路：
     * 单调栈
     * <p>
     * 常规思路：枚举所有子数组，求解
     * 逆向思路：遍历所有元素，每个元素为当前子数组的最小值，并保证当前子数组尽可能长。
     */
    public int maxSumMinProduct2(int[] nums) {
        int len = nums.length;

        int[] lefti = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                lefti[i] = -1;
            } else {
                lefti[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] righti = new int[len];
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            if (stack.empty()) {
                righti[i] = len;
            } else {
                righti[i] = stack.peek();
            }
            stack.push(i);
        }

        long[] preSum = new long[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }

        long res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, nums[i] * (preSum[righti[i]] - preSum[lefti[i] + 1]));
        }
        return (int) (res % (1000000007));
    }
}
