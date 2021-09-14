package pers.algorithm.leetcode.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LetterCombinations {

    List<String> ans = new ArrayList<>();

    Map<Character, String> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        initMap();
        traversal(digits, 0, new StringBuilder());
        return ans;
    }

    private void initMap() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    private void traversal(String digits, int i, StringBuilder sb) {
        if (digits.length() == i) {
            ans.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            int length = sb.length();
            sb.append(s.charAt(j));
            traversal(digits, i + 1, sb);
            sb.deleteCharAt(length);
        }
    }
}
