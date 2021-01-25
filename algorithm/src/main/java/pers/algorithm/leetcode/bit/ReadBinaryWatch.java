package pers.algorithm.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-watch/
 */
class ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int ic = oneCount(i);
                int jc = oneCount(j);
                if (ic + jc == num) {
                    result.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return result;
    }

    private int oneCount(int n) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            result += n & 1;
            n >>= 1;
        }
        return result;
    }
}
