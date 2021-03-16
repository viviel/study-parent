package pers.algorithm.leetcode.bit;

/**
 * https://leetcode-cn.com/problems/insert-into-bits-lcci/
 */
class InsertBits {

    /**
     * -     4  1
     * 10001001100
     */
    public int insertBits(int N, int M, int i, int j) {
        int tn = N;
        tn >>>= i;
        tn <<= i;
        tn <<= 31 - j;
        tn >>>= 31 - j;
        N ^= tn;
        return N | M << i;
    }
}
