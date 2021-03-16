package pers.algorithm.leetcode.bit;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 10
 * 输出：true
 * 解释：10 的二进制表示是：1010.
 * <p>
 * 示例 5：
 * <p>
 * 输入：n = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int t = n ^ (n >>= 1);
        return (t & (t + 1)) == 0;
    }
}
