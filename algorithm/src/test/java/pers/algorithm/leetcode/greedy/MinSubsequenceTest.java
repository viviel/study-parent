package pers.algorithm.leetcode.greedy;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSubsequenceTest {

    private final MinSubsequence o = new MinSubsequence();

    @Test
    void test1() {
        assertEquals(Lists.newArrayList(10, 9), o.minSubsequence(new int[]{4, 3, 10, 9, 8}));
        assertEquals(Lists.newArrayList(7, 7, 6), o.minSubsequence(new int[]{4, 4, 7, 6, 7}));
    }
}
