package pers.algorithm.leetcode.recursion;

/**
 * 泰波那契序列Tn定义如下：
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Tribonacci {

    public int tribonacci(int n) {
        return traversal(n);
    }

    private int traversal(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return traversal(n - 1) + traversal(n - 2) + traversal(n - 3);
    }

    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        for (int i = 0; i < n - 2; i++) {
            int t = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = t;
        }
        return n2;
    }
}
