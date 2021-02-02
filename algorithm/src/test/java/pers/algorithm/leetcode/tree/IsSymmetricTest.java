package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pers.algorithm.leetcode.tree.common.AGTreeUtils.generateTree4;
import static pers.algorithm.leetcode.tree.common.AGTreeUtils.generateTree5;

class IsSymmetricTest {

    private final IsSymmetric o = new IsSymmetric();

    @Test
    void test1() {
        assertTrue(o.isSymmetric(generateTree4()));
        assertFalse(o.isSymmetric(generateTree5()));
    }
}