package pers.algorithm.leetcode.greedy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> l1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (int e : nums2) {
            if (l1.remove((Integer) e)) {
                result.add(e);
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int e : nums1) {
            m1.put(e, m1.getOrDefault(e, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int e : nums2) {
            if (m1.containsKey(e)) {
                Integer v = m1.get(e);
                result.add(e);
                if (v == 1) {
                    m1.remove(e);
                } else {
                    m1.put(e, v - 1);
                }
            }
        }
        return result.stream().mapToInt(e -> e).toArray();
    }
}