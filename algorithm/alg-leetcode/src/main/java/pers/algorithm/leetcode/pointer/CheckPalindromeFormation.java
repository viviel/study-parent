package pers.algorithm.leetcode.pointer;

/**
 * 给你两个字符串a 和b，它们长度相同。请你选择一个下标，将两个字符串都在相同的下标 分割开。
 * 由a可以得到两个字符串：a_prefix和a_suffix，满足a = a_prefix + a_suffix，
 * 同理，由b 可以得到两个字符串b_prefix 和b_suffix，满足b = b_prefix + b_suffix。
 * 请你判断a_prefix + b_suffix 或者b_prefix + a_suffix能否构成回文串。
 * <p>
 * 当你将一个字符串s分割成s_prefix 和s_suffix时，s_suffix 或者s_prefix 可以为空。
 * 比方说，s = "abc"那么"" + "abc"，"a" + "bc"，"ab" + "c"和"abc" + ""都是合法分割。
 * <p>
 * 如果 能构成回文字符串 ，那么请返回true，否则返回false。
 * <p>
 * 注意，x + y表示连接字符串x 和y。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * a_prefix = "", a_suffix = "x"
 * b_prefix = "", b_suffix = "y"
 * 那么 a_prefix + b_suffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * a_prefix = "ula", a_suffix = "cfd"
 * b_prefix = "jiz", b_suffix = "alu"
 * 那么 a_prefix + b_suffix = "ula" + "alu" = "ulaalu" 是回文串。
 * 示例 4：
 * <p>
 * 输入：a = "xbdef", b = "xecab"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 10^5
 * a.length == b.length
 * a 和b都只包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-two-strings-to-make-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class CheckPalindromeFormation {

    public boolean checkPalindromeFormation(String a, String b) {
        if (check(a) || check(b) || a.length() == 1) {
            return true;
        }
        int m = a.length() / 2;
        int l, r;
        l = m - 1;
        if (a.length() % 2 == 0) {
            r = m;
        } else {
            r = m + 1;
        }
        return false;
    }

    protected boolean check(String s) {
        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l++) != s.charAt(h--)) {
                return false;
            }
        }
        return true;
    }
}
