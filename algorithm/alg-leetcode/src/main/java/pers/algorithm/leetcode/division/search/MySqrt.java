package pers.algorithm.leetcode.division.search;

/**
 * 实现int sqrt(int x)函数。
 * <p>
 * 计算并返回x的平方根，其中x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int i = 0, j = x;
        while (i + 1 < j) {
            int m = (i + j) / 2;
            if (x / m < m) {
                j = m;
            } else {
                i = m;
            }
        }
        return i;
    }
}