package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LetterCombinationsTest {

    private LetterCombinations o;

    @BeforeEach
    void setUp() {
        o = new LetterCombinations();
    }

    /**
     * 输入：digits = "23"
     * 2: abc
     * 3: def
     * <p>
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     */
    @Test
    void test1() {
        String digits = "23";
        List<String> ans = o.letterCombinations(digits);
    }

    @Test
    void test2() {
        String digits = "";
        List<String> ans = o.letterCombinations(digits);
    }

    @Test
    void test3() {
        String digits = "2";
        List<String> ans = o.letterCombinations(digits);
    }
}
