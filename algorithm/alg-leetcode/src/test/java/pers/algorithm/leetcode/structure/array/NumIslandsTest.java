package pers.algorithm.leetcode.structure.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumIslandsTest {

    private NumIslands o;

    @BeforeEach
    void setUp() {
        o = new NumIslands();
    }

    @Test
    void t1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int ans = o.numIslands(grid);
        assertEquals(1, ans);
    }

    @Test
    void t2() {
        char[][] grid = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        int ans = o.numIslands(grid);
        assertEquals(1, ans);
    }
}
