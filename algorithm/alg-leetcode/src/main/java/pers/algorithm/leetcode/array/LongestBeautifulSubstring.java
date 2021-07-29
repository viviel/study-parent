package pers.algorithm.leetcode.array;

/**
 * 当一个字符串满足如下条件时，我们称它是 美丽的：
 * <p>
 * 所有 5 个英文元音字母（'a'，'e'，'i'，'o'，'u'）都必须至少出现一次。
 * 这些元音字母的顺序都必须按照 字典序升序排布（也就是说所有的 'a'都在 'e'前面，所有的 'e'都在 'i'前面，以此类推）
 * 比方说，字符串"aeiou" 和"aaaaaaeiiiioou"都是 美丽的，但是"uaeio"，"aeoiu"和"aaaeeeooo"不是美丽的。
 * <p>
 * 给你一个只包含英文元音字母的字符串word，请你返回word 中 最长美丽子字符串的长度。如果不存在这样的子字符串，请返回 0。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * <p>
 * 示例 2：
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * <p>
 * 示例 3：
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 5 * 10^5
 * word只包含字符'a'，'e'，'i'，'o'和'u'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-of-all-vowels-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LongestBeautifulSubstring {

    /**
     * 012345
     */
    public int longestBeautifulSubstring(String word) {
        int r = 0;
        String y = "aeiou";
        for (int i = 0; i < word.length() - 4; ) {
            if (word.charAt(i) != 'a') {
                i++;
                continue;
            }
            for (int j = i + 1, k = 0; ; ) {
                if (j < word.length() && word.charAt(j) == y.charAt(k)) {
                    j++;
                } else if (k == y.length() - 1) {
                    r = Math.max(r, j - i);
                    i = j;
                    break;
                } else if (j < word.length() && word.charAt(j) == y.charAt(k + 1)) {
                    k++;
                } else {
                    i = j;
                    break;
                }
            }
        }
        return r;
    }
}
