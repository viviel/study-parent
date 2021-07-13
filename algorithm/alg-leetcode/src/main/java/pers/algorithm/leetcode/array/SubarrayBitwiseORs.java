package pers.algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 我们有一个非负整数数组A。
 * <p>
 * 对于每个（连续的）子数组B =[A[i], A[i+1], ..., A[j]] （i <= j），
 * 我们对B中的每个元素进行按位或操作，获得结果A[i] | A[i+1] | ... | A[j]。
 * <p>
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0]
 * 输出：1
 * 解释：
 * 只有一个可能的结果 0 。
 * 示例 2：
 * <p>
 * 输入：[1,1,2]
 * 输出：3
 * 解释：
 * 可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
 * 产生的结果为 1，1，2，1，3，3 。
 * 有三个唯一值，所以答案是 3 。
 * 示例3：
 * <p>
 * 输入：[1,2,4]
 * 输出：6
 * 解释：
 * 可能的结果是 1，2，3，4，6，以及 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 50000
 * 0 <= A[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-ors-of-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SubarrayBitwiseORs {

    /**
     * 动态规划
     * f(i, j) = f(i, j - 1) | arr[j]
     */
    public int subarrayBitwiseORs1(int[] arr) {
        Set<Integer> r = new HashSet<>();
        traversal(arr, 0, arr.length - 1, r);
        return r.size();
    }

    private void traversal(int[] arr, int l, int r, Set<Integer> set) {
        if (l > r) {
            return;
        }
        int t = 0;
        for (int i = l; i <= r; i++) {
            t = t | arr[i];
            set.add(t);
        }
        traversal(arr, l + 1, r, set);
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> r = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int t = 0;
            for (int j = i; j < arr.length; j++) {
                t = t | arr[j];
                r.add(t);
            }
        }
        return r.size();
    }
}
