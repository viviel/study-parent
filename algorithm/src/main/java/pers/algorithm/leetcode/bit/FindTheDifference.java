package pers.algorithm.leetcode.bit;

import java.util.Arrays;
import java.util.Objects;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串t由字符串s随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * <p>
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class FindTheDifference {

    /**
     * 或 与 异或
     */
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        for (int i = 0; i < s.length(); i++) {
            if (!Objects.equals(sc[i], tc[i])) {
                return tc[i];
            }
        }
        return tc[tc.length - 1];
    }

    public char findTheDifference2(String s, String t) {
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            temp ^= s.charAt(i) ^ t.charAt(i);
        }
        temp ^= t.charAt(t.length() - 1);
        return (char) temp;
    }

    public char findTheDifference3(String s, String t) {
        int ss = 0, st = 0;
        for (int i = 0; i < s.length(); i++) {
            ss += s.charAt(i);
            st += t.charAt(i);
        }
        st += t.charAt(t.length() - 1);
        return (char) (st - ss);
    }
}
