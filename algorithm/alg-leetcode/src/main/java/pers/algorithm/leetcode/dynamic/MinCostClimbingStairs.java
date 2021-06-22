package pers.algorithm.leetcode.dynamic;

/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为[0, 999] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinCostClimbingStairs {

    /**
     * 动态规划
     * <p>
     * [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * <p>
     * 0 2 4 6 7 9
     * <p>
     * 共消耗6
     * <p>
     * [1, 100]       f(2) = 1
     * [1, 100, 1]    f(3) = 2
     *
     * []             f(0) = 0
     * [10]           f(1) = 0
     * [10, 15]       f(2) = 10
     * [10, 15, 20]   f(3) = 15   max(f(2) + 20, f(1) + 15)
     *
     * f(n) = max(f(n - 1) + array[n - 1], f(n - 2) + array[n - 2])
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        int i = 0, j = 0;
        for (int k = 2; k <= cost.length; k++) {
            int t = Math.min(i + cost[k - 2], j + cost[k - 1]);
            i = j;
            j = t;
        }
        return j;
    }
}
