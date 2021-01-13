package pers.algorithm.leetcode.bit;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20= 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24= 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>>= 1;
        }
        return count == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n < 1) {
            return false;
        }
        return (n - 1 & n) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n < 1) {
            return false;
        }
        switch (n) {
            case 1:
            case 1 << 1:
            case 1 << 2:
            case 1 << 3:
            case 1 << 4:
            case 1 << 5:
            case 1 << 6:
            case 1 << 7:
            case 1 << 8:
            case 1 << 9:
            case 1 << 10:
            case 1 << 11:
            case 1 << 12:
            case 1 << 13:
            case 1 << 14:
            case 1 << 15:
            case 1 << 16:
            case 1 << 17:
            case 1 << 18:
            case 1 << 19:
            case 1 << 20:
            case 1 << 21:
            case 1 << 22:
            case 1 << 23:
            case 1 << 24:
            case 1 << 25:
            case 1 << 26:
            case 1 << 27:
            case 1 << 28:
            case 1 << 29:
            case 1 << 30:
                return true;
            default:
                return false;
        }
    }
}