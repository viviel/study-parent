package pers.algorithm.leetcode.dynamic;

class NumDecodings2 extends NumDecodings {

    /**
     * f(n) = f(n - 1) + f(n - 2)
     */
    @Override
    public int numDecodings(String s) {
        int n1 = 1, n2 = 1;
        if (s.charAt(s.length() - 1) == '0') {
            n1 = 0;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                n2 = n1;
                n1 = 0;
                continue;
            }
            int temp = n1;
            if (Integer.parseInt(s.substring(i, i + 2)) < 27) {
                temp += n2;
            }
            n2 = n1;
            n1 = temp;
        }
        return n1;
    }
}
