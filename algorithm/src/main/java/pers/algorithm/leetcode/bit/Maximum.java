package pers.algorithm.leetcode.bit;

/**
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * <p>
 * 示例：
 * <p>
 * 输入： a = 1, b = 2
 * 输出： 2
 */
class Maximum {

    public int maximum(int a, int b) {
        long dif = (long) a - (long) b;
        int k = (int) (dif >>> 63);
        return a * (k ^ 1) + b * k;
    }

    public int maximum2(int a, int b) {
        return (Math.abs(a - b) + a + b) / 2;
    }
}
