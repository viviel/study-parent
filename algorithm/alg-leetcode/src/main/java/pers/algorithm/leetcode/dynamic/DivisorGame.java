package pers.algorithm.leetcode.dynamic;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字N。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一x，满足0 < x < N 且N % x == 0。
 * 用 N - x替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 */
class DivisorGame {

    /**
     * 1 false
     * <p>
     * 2 1 true
     * <p>
     * 3 1 false
     * 2 1 true
     * <p>
     * 4 1/2 true
     * 3 false
     * 2 true
     * <p>
     * 5 1 false
     * 4 true
     * <p>
     * 6 1/2/3 true
     * 5 false
     * 4 true
     * 3 false
     * <p>
     * 7
     * <p>
     * 8 1/2/4
     * <p>
     * 9 1/3
     * <p>
     * f(n) = f(n - 1) || f(n - m)
     */
    public boolean divisorGame(int n) {
        boolean[] f = new boolean[n + 2];  // 防止 n = 1 的时候，f[2] 越界
        f[2] = true;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];
        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
