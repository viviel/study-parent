package pers.algorithm.leetcode.pointer;

import java.util.Objects;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class IsPalindrome {

    public boolean isPalindrome(String s) {
        String tStr = s.toLowerCase();
        int i = 0, j = tStr.length() - 1;
        while (i < j) {
            if (invalidChar(tStr.charAt(i))) {
                i++;
                continue;
            } else if (invalidChar(tStr.charAt(j))) {
                j--;
                continue;
            }
            if (Objects.equals(tStr.charAt(i), tStr.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean invalidChar(Character c) {
        boolean isNum = '0' <= c && c <= '9';
        boolean isChar = 'a' <= c && c <= 'z';
        return !isNum && !isChar;
    }
}
