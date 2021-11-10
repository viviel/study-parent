package pers.algorithm.leetcode.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PartitionTest {

    private Partition o;

    @BeforeEach
    void setUp() {
        o = new Partition();
    }

    /**
     * aab
     * a a b
     * aa b
     */
    @Test
    void t1() {
        List<List<String>> ans = o.partition("aab");
    }

    /**
     * abcbadfg
     * abcba d f g
     * a bcb a d f g
     * a b c b a d f g
     */
    @Test
    void t2() {
        List<List<String>> ans = o.partition("abcbadfg");
    }
}
