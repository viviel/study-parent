package pers.algorithm.leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * 示例1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母a-z。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();
        o.exe();
    }

    public void exe() {
        String[] ss = new String[]{"a", "ab"};
        System.out.println(longestCommonPrefix1(ss));
        System.out.println(longestCommonSubStr("abcdef", "ddddef"));
    }

    /**
     * "abcdef"
     * "ddddef"
     */
    public String longestCommonPrefix1(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String result = "";
        int min = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();
        a:
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    break a;
                }
            }
            result = strs[0].substring(0, i + 1);
        }
        return result;
    }

    private String longestCommonSubStr(String s1, String s2) {
        String s = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                for (int offset = 0;
                     i + offset < s1.length() &&
                     j + offset < s2.length() &&
                     s1.charAt(i + offset) == s2.charAt(j + offset);
                     offset++
                ) {
                    String temp = s1.substring(i, i + offset + 1);
                    if (temp.length() > s.length()) {
                        s = temp;
                    }
                }
            }
        }
        return s;
    }

}
