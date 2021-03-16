package pers.algorithm.leetcode.stack;

/**
 * https://leetcode-cn.com/problems/crawler-log-folder/
 */
public class MinOperations {

    public int minOperations(String[] logs) {
        int r = 0;
        for (String e : logs) {
            switch (e) {
                case "../": {
                    if (r > 0) {
                        r--;
                    }
                    break;
                }
                case "./": {
                    break;
                }
                default: {
                    r++;
                }
            }
        }
        return r;
    }
}
