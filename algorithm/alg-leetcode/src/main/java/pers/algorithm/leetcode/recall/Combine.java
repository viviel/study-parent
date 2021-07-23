package pers.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Combine {

    private final Stack<Integer> temp = new Stack<>();

    private final List<List<Integer>> r = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        traversal(1, n, k);
        return r;
    }

    private void traversal(int current, int n, int k) {
        if (temp.size() + (n - current + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            r.add(new ArrayList<>(temp));
            return;
        }
        temp.add(current);
        traversal(current + 1, n, k);
        temp.pop();
        traversal(current + 1, n, k);
    }
}
