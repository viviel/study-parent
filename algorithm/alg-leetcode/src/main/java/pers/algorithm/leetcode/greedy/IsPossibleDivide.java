package pers.algorithm.leetcode.greedy;

import java.util.TreeMap;

/**
 * 给你一个整数数组nums和一个正整数k，请你判断是否可以把这个数组划分成一些由k个连续数字组成的集合。
 * 如果可以，请返回True；否则，返回False。
 * <p>
 * <p>
 * <p>
 * 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 * 输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * 输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 * 示例 3：
 * <p>
 * 输入：nums = [3,3,2,2,1,1], k = 3
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3,4], k = 3
 * 输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsPossibleDivide {

    public boolean isPossibleDivide(int[] nums, int k) {
        if ((nums.length % k) != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            Integer count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        while (map.size() != 0) {
            int begin = map.firstKey();
            for (int i = begin; i < begin + k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                Integer count = map.get(i);
                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
            }
        }
        return true;
    }
}
