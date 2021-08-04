package pers.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CombinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        traversal(1, k, n, new Stack<>());
        return ans;
    }

    private void traversal(int i, int k, int n, Stack<Integer> stack) {
        if (i > 10 || stack.size() > k) {
            return;
        }
        if (stack.size() == k) {
            int s = 0;
            for (Integer e : stack) {
                s += e;
            }
            if (s == n) {
                ans.add(new ArrayList<>(stack));
            }
            return;
        }
        stack.push(i);
        traversal(i + 1, k, n, stack);
        stack.pop();
        traversal(i + 1, k, n, stack);
    }
}
