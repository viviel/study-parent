package pers.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回0。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * <p>
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-perimeter-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LargestPerimeter {

    public int largestPerimeter(int[] a) {
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 2; i--) {
            if (a[i - 2] + a[i - 1] > a[i]) {
                return a[i - 2] + a[i - 1] + a[i];
            }
        }
        return 0;
    }
}