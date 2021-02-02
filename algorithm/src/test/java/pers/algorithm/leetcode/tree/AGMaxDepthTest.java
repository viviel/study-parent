package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pers.algorithm.leetcode.tree.common.AGTreeUtils.generateTree6;

class AGMaxDepthTest {

    private final AGMaxDepth o = new AGMaxDepth();

    @Test
    void test1() {
        assertEquals(3, o.maxDepth(generateTree6()));
    }
}
