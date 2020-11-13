package pers.algorithm.leetcode;

import java.util.Stack;

public class IsValid {

    public boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop == '(' && c != ')') {
                    return false;
                }
                if (pop == '{' && c != '}') {
                    return false;
                }
                if (pop == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
