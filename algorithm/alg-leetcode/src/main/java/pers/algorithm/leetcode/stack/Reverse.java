package pers.algorithm.leetcode.stack;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, 2^31− 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse2(1111111112));
    }

    public int reverse(int x) {
        int tempX = x;
        if (x < 0) {
            tempX = -x;
        }

        String s = String.valueOf(tempX);
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            temp.append(s.charAt(i));
        }

        int result;
        try {
            result = Integer.parseInt(temp.toString());
            if (x < 0) {
                result = -result;
            }
        } catch (Exception e) {
            result = 0;
        }

        return result;
    }

    public int reverse1(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public int reverse2(int x) {
        long temp = 0;
        while (x != 0) {
            temp = x % 10 + temp * 10;
            x = x / 10;
        }

        return (int) temp == temp ? (int) temp : 0;
    }

}