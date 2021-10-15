package pers.algorithm.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> numSet = getNumSet();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (numSet.contains(c)) {
                    numSet.remove(c);
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> numSet = getNumSet();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (numSet.contains(c)) {
                    numSet.remove(c);
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Character> numSet = getNumSet();
                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        char c = board[k][l];
                        if (c == '.') {
                            continue;
                        }
                        if (numSet.contains(c)) {
                            numSet.remove(c);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private Set<Character> getNumSet() {
        Set<Character> ans = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            ans.add((char) (i + 1 + '0'));
        }
        return ans;
    }
}
