package pers.algorithm.leetcode.dynamic;

class MaxAbsoluteSum2 extends MaxAbsoluteSum {

    @Override
    public int maxAbsoluteSum(int[] nums) {
        int prefix = 0, max = 0, min = 0;
        for (int x : nums) {
            prefix += x;
            if (prefix > max) {
                max = prefix;
            }
            if (prefix < min) {
                min = prefix;
            }
        }
        return max - min;
    }
}
