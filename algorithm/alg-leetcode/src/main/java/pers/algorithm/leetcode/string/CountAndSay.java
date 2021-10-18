package pers.algorithm.leetcode.string;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 */
class CountAndSay {

    /**
     * f(n) = desc(f(n - 1))
     * <p>
     * f(1) = "1"
     * f(2) = desc("1") = "11"
     * f(3) = desc("11") = "21"
     * f(4) = desc("21") = "1211"
     * f(5) = desc("1211") = "111221"
     * <p>
     * 递归：逆向思维
     * 可以直接正向遍历
     * <p>
     * 两种极端思维方式
     */
    public String countAndSay(int n) {
        return traversal(n);
    }

    private String traversal(int n) {
        if (n == 1) {
            return "1";
        }
        String s = traversal(n - 1);
        return desc(s);
    }

    String desc(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char pre = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (pre == s.charAt(i)) {
                count++;
            } else {
                sb.append(count).append(pre);
                count = 1;
                pre = s.charAt(i);
            }
        }
        sb.append(count).append(pre);
        return sb.toString();
    }
}
