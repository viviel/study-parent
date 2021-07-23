package pers.algorithm.leetcode.recall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class CombineTest {

    private Combine o;

    @BeforeEach
    void setUp() {
        o = new Combine();
    }

    @Test
    void test1() {
        List<List<Integer>> r = o.combine(4, 2);
    }
}
