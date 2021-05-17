package pers.algorithm.leetcode;

public class SubString {

    public void subString(String s) {
        dfs(s, 0, "");
    }

    private void dfs(String s, int i, String sub) {
        if (s.length() == i) {
            System.out.println(sub);
            return;
        }
        dfs(s, i + 1, sub + s.charAt(i));
        dfs(s, i + 1, sub);
    }
}
