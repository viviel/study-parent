package pers.algorithm.leetcode.bit;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 16
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：false
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsPowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }
        int temp = n;
        while (temp != 1) {
            if (temp % 4 != 0) {
                return false;
            } else {
                temp = temp / 4;
            }
        }
        return true;
    }

    public boolean isPowerOfFour2(int n) {
        if (n < 1) {
            return false;
        }
        while (n != 1) {
            if ((n & 3) != 0) {
                return false;
            } else {
                n = n >> 2;
            }
        }
        return true;
    }
}
