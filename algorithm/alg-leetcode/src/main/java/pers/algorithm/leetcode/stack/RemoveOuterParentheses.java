package pers.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 * <p>
 * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 * <p>
 * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为"(" 或")"
 * S 是一个有效括号字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        return primitiveStr(s, 0);
    }

    private String primitiveStr(String s, int i) {
        int r = i;
        if (r == s.length()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        while (true) {
            if (s.charAt(r) == '(') {
                stack.push(s.charAt(r));
            } else {
                if (stack.size() == 1) {
                    return s.substring(i + 1, r) + primitiveStr(s, r + 1);
                } else {
                    stack.pop();
                }
            }
            r++;
        }
    }

    public String removeOuterParentheses2(String s) {
        return primitiveStr2(s, 0).toString();
    }

    private CharSequence primitiveStr2(CharSequence sb, int i) {
        int r = i;
        if (r == sb.length()) {
            return new StringBuilder();
        }
        int n = 0;
        while (true) {
            if (sb.charAt(r) == '(') {
                n++;
            } else {
                if (n == 1) {
                    return new StringBuffer(sb.subSequence(i + 1, r)).append(primitiveStr2(sb, r + 1));
                } else {
                    n--;
                }
            }
            r++;
        }
    }

    public String removeOuterParentheses3(String s) {
        int base = 0;
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                n++;
            } else {
                if (n == 1) {
                    sb.append(s.substring(base + 1, i));
                    base = i + 1;
                    n = 0;
                } else {
                    n--;
                }
            }
        }
        return sb.toString();
    }

}
