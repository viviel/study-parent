package pers.algorithm.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * 输入:"III"
 * 输出: 3
 * <p>
 * 示例2:
 * 输入:"IV"
 * 输出: 4
 * <p>
 * 示例3:
 * 输入:"IX"
 * 输出: 9
 * <p>
 * 示例4:
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例5:
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 */
public class RomanToInt {

    private final Map<Character, Integer> romanMap = new HashMap<>();

    public RomanToInt() {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInt o = new RomanToInt();
        o.exe();
    }

    public void exe() {
        String v = "IVI";
        System.out.println(solution1(v));
        System.out.println(solution2(v));
        System.out.println(solution3(v));
    }

    public Integer solution1(String s) {
        AtomicReference<String> p = new AtomicReference<>(s);
        Map<String, String> transfer = new HashMap<>();
        transfer.put("IV", "IIII");
        transfer.put("IX", "VIIII");
        transfer.put("XL", "XXXX");
        transfer.put("XC", "LXXXX");
        transfer.put("CD", "CCCC");
        transfer.put("CM", "DCCCC");
        transfer.forEach((key, value) -> p.set(p.get().replace(key, value)));
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < p.get().length(); i++) {
            char c = p.get().charAt(i);
            result += romanMap.get(c);
        }
        return result;
    }

    public Integer solution2(String s) {
        if (null == s || s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int result = romanMap.get(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            int current = romanMap.get(s.charAt(i));
            int next = romanMap.get(s.charAt(i + 1));
            if (next > current) {
                result = result - current + (next - current);
            } else {
                result += next;
            }
        }
        return result;
    }

    public int solution3(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
