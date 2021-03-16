package pers.algorithm.leetcode.greedy;

/**
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 */
class MinDeletionSize {

    public int minDeletionSize(String[] a) {
        int result = 0;
        for (int i = 0; i < a[0].length(); i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j].charAt(i) > a[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}