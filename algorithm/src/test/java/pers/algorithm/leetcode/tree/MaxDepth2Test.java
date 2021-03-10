package pers.algorithm.leetcode.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxDepth2Test {

    private final MaxDepth2 o = new MaxDepth2();

    @Test
    void test1() {
        assertEquals(3, o.maxDepth(generateTree()));
    }

    private MaxDepth2.Node generateTree() {
        MaxDepth2.Node r = new MaxDepth2.Node(1, new ArrayList<>());
        r.children.add(new MaxDepth2.Node(3, new ArrayList<>()));
        r.children.add(new MaxDepth2.Node(2));
        r.children.add(new MaxDepth2.Node(4));
        r.children.get(0).children.add(new MaxDepth2.Node(5));
        r.children.get(0).children.add(new MaxDepth2.Node(6));
        return r;
    }
}