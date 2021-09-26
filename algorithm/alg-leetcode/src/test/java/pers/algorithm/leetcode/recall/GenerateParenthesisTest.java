package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GenerateParenthesisTest {

    private GenerateParenthesis o;

    @BeforeEach
    void setUp() {
        o = new GenerateParenthesis();
    }

    @Test
    void test1() {
        List<String> ans = o.generateParenthesis(3);
    }

    @Test
    void test2() {
        List<String> ans = o.generateParenthesis(1);
    }
}
