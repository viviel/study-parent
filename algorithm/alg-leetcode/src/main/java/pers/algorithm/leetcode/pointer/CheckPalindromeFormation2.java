package pers.algorithm.leetcode.pointer;

class CheckPalindromeFormation2 extends CheckPalindromeFormation {

    @Override
    public boolean checkPalindromeFormation(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int size = a.length();
        if (isPalindrome(str1, 0, size - 1) || isPalindrome(str2, 0, size - 1)) {
            return true;
        }
        return helper(str1, str2) || helper(str2, str1);
    }

    public boolean isPalindrome(char[] s1, int start, int end) {
        while (start < end) {
            if (s1[start] != s1[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean helper(char[] s1, char[] s2) {
        int i = 0, j = s2.length - 1;
        while (i < j) {
            if (s1[i] == s2[j]) {
                i++;
                j--;
            } else {
                break;
            }
        }
        return isPalindrome(s1, i, j) || isPalindrome(s2, i, j);
    }
}
