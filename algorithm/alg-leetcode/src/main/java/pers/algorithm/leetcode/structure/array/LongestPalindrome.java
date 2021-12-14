package pers.algorithm.leetcode.structure.array;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LongestPalindrome {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int l, r;
            for (l = i, r = i; l >= 0 && r < s.length(); l--, r++) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > ans.length()) {
                        ans = s.substring(l, r + 1);
                    }
                } else {
                    break;
                }
            }
            for (l = i, r = i + 1; l >= 0 && r < s.length(); l--, r++) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > ans.length()) {
                        ans = s.substring(l, r + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
