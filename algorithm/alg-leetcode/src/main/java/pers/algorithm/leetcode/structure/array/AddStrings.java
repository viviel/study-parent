package pers.algorithm.leetcode.structure.array;

/**
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * <p>
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 10^4
 * num1 和num2 都只包含数字0-9
 * num1 和num2 都不包含任何前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int step = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int c1 = 0;
            if (i < num1.length()) {
                c1 = num1.charAt(num1.length() - 1 - i) - '0';
            }
            int c2 = 0;
            if (i < num2.length()) {
                c2 = num2.charAt(num2.length() - 1 - i) - '0';
            }
            int sum = c1 + c2 + step;
            sb.insert(0, sum % 10);
            step = sum / 10;
        }
        if (step != 0) {
            sb.insert(0, step);
        }
        return sb.toString();
    }
}
