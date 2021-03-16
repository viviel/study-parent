package pers.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> result = new TreeSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int e : nums1) {
            set.add(e);
        }
        for (int e : nums2) {
            if (set.contains(e)) {
                result.add(e);
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> list1 = new HashSet<>();
        for (int e : nums1) {
            list1.add(e);
        }
        Set<Integer> list2 = new HashSet<>();
        for (int e : nums2) {
            list2.add(e);
        }
        list1.retainAll(list2);
        return list1.stream().mapToInt(e -> e).toArray();
    }
}