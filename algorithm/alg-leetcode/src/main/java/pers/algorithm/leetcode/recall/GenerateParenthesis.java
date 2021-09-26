package pers.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        char[] c = new char[n * 2];
        List<String> ans = new ArrayList<>();
        traversal(c, 0, ans);
        return ans;
    }

    private void traversal(char[] c, int i, List<String> r) {
        if (i == c.length) {
            if (valid(c)) {
                r.add(new String(c));
            }
            return;
        }
        c[i] = '(';
        traversal(c, i + 1, r);
        c[i] = ')';
        traversal(c, i + 1, r);
    }

    private boolean valid(char[] c) {
        if (c.length == 0 || c[0] != '(') {
            return false;
        }
        int i = 0;
        for (char e : c) {
            if (e == '(') {
                i++;
            } else if (--i < 0) {
                return false;
            }
        }
        return i == 0;
    }
}
