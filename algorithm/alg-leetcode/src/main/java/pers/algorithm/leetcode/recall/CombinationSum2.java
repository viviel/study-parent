package pers.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <=candidates.length <= 100
 * 1 <=candidates[i] <= 50
 * 1 <= target <= 30
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CombinationSum2 {

    private final Set<List<Integer>> ans = new HashSet<>();

    /**
     * 时间复杂度：O(2^n)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traversal(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(ans);
    }

    private void traversal(int[] candidates, int target, int i, List<Integer> selected, int sum) {
        if (target == sum) {
            ans.add(new ArrayList<>(selected));
            return;
        } else if (target < sum) {
            return;
        }
        if (i == candidates.length) {
            return;
        }
        if (i != 0 && candidates[i] == candidates[i - 1] && selected.isEmpty()) {
            traversal(candidates, target, i + 1, selected, sum);
        } else {
            selected.add(candidates[i]);
            traversal(candidates, target, i + 1, selected, sum + candidates[i]);
            selected.remove(selected.size() - 1);
            traversal(candidates, target, i + 1, selected, sum);
        }
    }
}
