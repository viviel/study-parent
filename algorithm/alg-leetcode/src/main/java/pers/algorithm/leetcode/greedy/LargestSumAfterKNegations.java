package pers.algorithm.leetcode.greedy;

import java.util.PriorityQueue;

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * <p>
 * 以这种方式修改数组后，返回数组可能的最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * <p>
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * <p>
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] a, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int e : a) {
            p.add(e);
        }
        for (int i = 0; i < k; i++) {
            if (!p.isEmpty()) {
                p.add(-p.poll());
            }
        }
        return p.stream().mapToInt(e -> e).sum();
    }

    /**
     * 空间换时间
     */
    public int largestSumAfterKNegations2(int[] a, int k) {
        int[] t = new int[201];
        for (int e : a) {
            t[e + 100]++;
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < t.length; j++) {
                if (t[j] != 0) {
                    t[j]--;
                    t[200 - j]++;
                    break;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 0) {
                continue;
            }
            for (int j = 0; j < t[i]; j++) {
                result += i - 100;
            }
        }
        return result;
    }
}