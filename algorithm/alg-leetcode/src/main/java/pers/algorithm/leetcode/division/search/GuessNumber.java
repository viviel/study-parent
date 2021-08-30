package pers.algorithm.leetcode.division.search;

import pers.algorithm.leetcode.division.search.common.GuessGame;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2^31 - 1
 * 1 <= pick <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GuessNumber extends GuessGame {

    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i <= j) {
            int m = i + (j - i) / 2;
            int guess = guess(m);
            if (guess == 0) {
                return m;
            } else if (guess == -1) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return 0;
    }
}