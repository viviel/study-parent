package pers.algorithm.leetcode.division.search;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int i = 1, j = num;
        while (i <= j) {
            int m = (i + j) / 2;
            int d = num / m;
            int y = num % m;
            if (m == d && y == 0) {
                return true;
            } else if (m <= d) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return false;
    }
}