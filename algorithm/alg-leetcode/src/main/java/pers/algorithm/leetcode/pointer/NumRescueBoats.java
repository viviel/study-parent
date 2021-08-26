package pers.algorithm.leetcode.pointer;

import java.util.Arrays;

/**
 * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
 * <p>
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 * <p>
 * 1 <=people.length <= 50000
 * 1 <= people[i] <=limit <= 30000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class NumRescueBoats {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0, j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            ans++;
        }
        if (i == j && people[i] <= limit) {
            ans++;
        }
        return ans;
    }
}
