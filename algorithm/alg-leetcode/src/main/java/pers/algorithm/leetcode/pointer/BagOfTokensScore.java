package pers.algorithm.leetcode.pointer;

import java.util.Arrays;

/**
 * 你的初始 能量 为P，初始 分数 为0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
 * <p>
 * 令牌可能的两种使用方法如下：
 * <p>
 * 如果你至少有token[i]点 能量 ，可以将令牌 i 置为正面朝上，失去token[i]点 能量 ，并得到1分 。
 * 如果我们至少有1分 ，可以将令牌 i 置为反面朝上，获得token[i] 点 能量 ，并失去1分 。
 * 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
 * <p>
 * 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = [100], P = 50
 * 输出：0
 * 解释：无法使用唯一的令牌，因为能量和分数都太少了。
 * <p>
 * 示例 2：
 * <p>
 * 输入：tokens = [100,200], P = 150
 * 输出：1
 * 解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。不必使用令牌 1 ，因为你无法使用它来提高分数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：tokens = [100,200,300,400], P = 200
 * 输出：2
 * 解释：按下面顺序使用令牌可以得到 2 分：
 * 1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
 * 2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
 * 3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
 * 4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= tokens.length <= 1000
 * 0 <= tokens[i],P < 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bag-of-tokens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class BagOfTokensScore {

    public int bagOfTokensScore1(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }
        Arrays.sort(tokens);
        if (tokens[0] > power) {
            return 0;
        }
        int score = 0;
        int i = 0, j = tokens.length - 1;
        do {
            int tPower = 0;
            int tScore = 0;
            for (int k = i; k <= j; k++) {
                tPower += tokens[k];
                if (tPower <= power) {
                    tScore++;
                } else {
                    break;
                }
            }
            if (score <= tScore) {
                score = tScore;
            } else {
                return score;
            }
            power = power + tokens[j] - tokens[i];
            i++;
            j--;
        } while (i < j);
        return score;
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int points = 0, ans = 0;
        while (lo <= hi && (P >= tokens[lo] || points > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                points++;
            }
            ans = Math.max(ans, points);
            if (lo <= hi && points > 0) {
                P += tokens[hi--];
                points--;
            }
        }
        return ans;
    }
}
