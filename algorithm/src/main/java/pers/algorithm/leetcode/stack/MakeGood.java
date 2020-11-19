package pers.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-the-string-great
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MakeGood {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && i < chars.length && illegal(stack.peek(), chars[i])) {
                stack.pop();
                i++;
            }
            if (i < chars.length) {
                stack.push(chars[i]);
            }
        }
        stack.forEach(sb::append);
        return sb.toString();
    }

    private boolean illegal(char a, char b) {
        return a - b == 32 || b - a == 32;
    }

    public String makeGood2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = -1;
        while (len != sb.length()) {
            len = sb.length();
            for (int i = 0; i < sb.length() - 1; i++) {
                if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 'a' - 'A') {
                    sb.delete(i, i + 2);
                    break;
                }
            }
        }
        return sb.toString();
    }

}
