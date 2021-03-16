package pers.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。找到nums1中每个元素在nums2中的下一个比其大的值。
 * <p>
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * <p>
 * 输出: [-1,3,-1]
 * <p>
 * 解释:
 * <p>
 * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * <p>
 * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * <p>
 * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * <p>
 * 输出: [3,-1]
 * <p>
 * 解释:
 * <p>
 * 对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * <p>
 * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * <p>
 * 提示：
 * <p>
 * nums1和nums2中所有元素是唯一的。
 * <p>
 * nums1和nums2的数组大小都不超过1000。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums2) {
            while (!s.isEmpty() && s.peek() < n) {
                map.put(s.pop(), n);
            }
            s.push(n);
        }
        int[] r = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            r[i] = map.getOrDefault(nums1[i], -1);
        }
        return r;
    }

}
