package pers.algorithm.leetcode.division.search;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        char c = target;
        for (int i = 0; i < 25; i++) {
            c = add1(c);
            int l = 0, r = letters.length - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (letters[m] == c) {
                    return c;
                } else if (letters[m] < c) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return 'a';
    }

    char add1(char c) {
        return (char) ((c - 'a' + 1) % 26 + 'a');
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return letters[l % letters.length];
    }
}