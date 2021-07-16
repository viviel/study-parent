package pers.algorithm.leetcode.pointer;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的二进制字符串s和两个整数minJump 和maxJump。一开始，你在下标0处，且该位置的值一定为'0'。
 * 当同时满足如下条件时，你可以从下标i移动到下标j处：
 * <p>
 * i + minJump <= j <= min(i + maxJump, s.length - 1)且
 * s[j] == '0'.
 * 如果你可以到达 s的下标s.length - 1处，请你返回true，否则返回false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 * <p>
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 10^5
 * s[i]要么是'0'，要么是'1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-vii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CanReach {

    /**
     * 动态规划
     * f(i) = any(f(j)), 其中 j ∈ [i − maxJump, i − minJump] 并且 j ≥ 0
     */
    public boolean canReach1(String s, int minJump, int maxJump) {
        boolean[] b = new boolean[s.length()];
        b[0] = true;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                continue;
            }
            for (int j = minJump; j <= maxJump; j++) {
                if (i - j >= 0 && b[i - j]) {
                    b[i] = true;
                    break;
                }
            }
        }
        return b[s.length() - 1];
    }

    /**
     * |       1 1
     * | 0 0 0 1 1 1
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        //长度
        int len = s.length();
        //记录某个点是否能达到 如果能到就是0 ,不能达到就是1
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        dp[1] = 0;
        //这个是前缀和的数组，记录的是dp这个数组的前缀和
        int[] bdp = new int[len + 1];
        bdp[1] = 0;
        //遍历数组
        for (int i = 2; i < len + 1; i++) {
            //选择chars[i - 1]为 0  通过判断这个点的 i - maxJump 到 i - minJump 点的和 是否比 这两个点的距离之和近
            //如果近就说明这里面至少存在一个0 那么就可以通过这个0 来到达chars[i - 1]这个点
            if (s.charAt(i - 1) == '0') {
                if (i - minJump >= 1) {
                    int r = i - minJump;
                    int l = Math.max(i - maxJump, 1);
                    dp[i] = bdp[r] - bdp[l - 1] < r - l + 1 ? 0 : 1;
                }
            }
            //每次都维护前缀和数组,加入 0 或者 1
            bdp[i] += bdp[i - 1] + dp[i];
        }
        return dp[len] == 0;
    }
}
