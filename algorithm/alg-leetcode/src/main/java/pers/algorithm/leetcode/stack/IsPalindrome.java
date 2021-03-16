package pers.algorithm.leetcode.stack;

import java.util.Objects;

class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(1211));
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (!Objects.equals(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

}