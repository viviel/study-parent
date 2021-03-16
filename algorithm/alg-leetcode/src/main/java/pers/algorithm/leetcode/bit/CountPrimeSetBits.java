package pers.algorithm.leetcode.bit;

/**
 * 给定两个整数L和R，找到闭区间[L, R]范围内，计算置位位数为质数的整数个数。
 * <p>
 * （注意，计算置位代表二进制表示中1的个数。例如21的二进制表示10101有 3 个计算置位。还有，1 不是质数。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * <p>
 * 示例 2:
 * <p>
 * 输入: L = 10, R = 15
 * 输出: 5
 * 解释:
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 注意:
 * <p>
 * L, R是L <= R且在[1, 10^6]中的整数。
 * R - L的最大值为 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CountPrimeSetBits {

    private boolean isZ(int i) {
        if (i < 2) {
            return false;
        } else if (i == 2) {
            return true;
        } else {
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int countPrimeSetBits(int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (isZ(z(i))) {
                result++;
            }
        }
        return result;
    }

    private int z(int i) {
        int flag = 1;
        int result = 0;
        for (int j = 0; j < 31; j++) {
            if ((i & flag) == 1) {
                result++;
            }
            i >>= 1;
        }
        return result;
    }

    public int countPrimeSetBits2(int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (isZ(Integer.bitCount(i))) {
                result++;
            }
        }
        return result;
    }

    public int countPrimeSetBits3(int l, int r) {
        int[] table = new int[33];
        table[2] = 1;
        table[3] = 1;
        table[5] = 1;
        table[7] = 1;
        table[11] = 1;
        table[13] = 1;
        table[17] = 1;
        table[19] = 1;
        table[23] = 1;
        table[29] = 1;
        table[31] = 1;
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (table[Integer.bitCount(i)] == 1) {
                result++;
            }
        }
        return result;
    }

    public int countPrimeSetBits4(int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            // 665772: 0000 0000 0000 1010 0010 1000 1010 1100
            if ((665772 >> Integer.bitCount(i) & 1) == 1) {
                result++;
            }
        }
        return result;
    }
}