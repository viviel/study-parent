package pers.algorithm.leetcode.structure.array;

/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        if (n == 0) {
            return;
        }
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (j < m && k < n) {
            if (nums1[j] < nums2[k]) {
                temp[i] = nums1[j++];
            } else {
                temp[i] = nums2[k++];
            }
            i++;
        }
        if (j != m) {
            for (; j < m; j++) {
                temp[i++] = nums1[j];
            }
        }
        if (k != n) {
            for (; k < n; k++) {
                temp[i++] = nums2[k];
            }
        }
        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }

    /**
     * 逆向遍历，不需要考虑数组元素移动问题
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
            i--;
        }
        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
    }
}
