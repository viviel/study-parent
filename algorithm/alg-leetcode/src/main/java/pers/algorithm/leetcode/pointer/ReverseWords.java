package pers.algorithm.leetcode.pointer;

/**
 * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * <p>
 * 说明：
 * <p>
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = " hello world "
 * 输出："world hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入：s = "a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
 * 示例 4：
 * <p>
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * <p>
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^4
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 请尝试使用O(1) 额外空间复杂度的原地解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        String[] split = s.split(" ");
        StringBuilder r = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].equals("")) {
                r.append(split[i].trim()).append(" ");
            }
        }
        if (r.length() == 0) {
            return "";
        }
        return r.subSequence(0, r.length() - 1).toString();
    }
}
