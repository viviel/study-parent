package pers.algorithm.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        Integer target = nums.length / 2;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > target) {
                return e.getKey();
            }
        }
        return 0;
    }

    /**
     * 与 或 异或
     */
    public int majorityElement2(int[] nums) {
        int result = 0, count = 0;
        for (int e : nums) {
            if (count == 0) {
                result = e;
                count++;
            } else if (result == e) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}