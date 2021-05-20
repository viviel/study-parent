package pers.vv.study.algorithm.sort;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class NumWays {

    private int r = 0;

    /**
     * 1
     * 1
     * <p>
     * 2
     * 1 1
     * 2
     * <p>
     * 3
     * 1 1 1
     * 1 2
     * 2 1
     *
     * f(n) = f(n - 1) + f(n - 2)
     * 得出：斐波那契数列
     */
    public int numWays(int n) {
        traversal(n);
        return r;
    }

    private void traversal(int n) {
        if (n == 0) {
            r = (r + 1) % 1000000007;
            return;
        } else if (n < 0) {
            return;
        }
        traversal(n - 1);
        traversal(n - 2);
    }
}
