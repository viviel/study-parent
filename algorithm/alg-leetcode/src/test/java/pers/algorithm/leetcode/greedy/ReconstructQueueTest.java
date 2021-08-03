package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReconstructQueueTest {

    private ReconstructQueue o;

    @BeforeEach
    void setUp() {
        o = new ReconstructQueue();
    }

    @Test
    void test1() {
        int[][] people = new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        };
        int[][] expected = new int[][]{
                {5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}
        };
        int[][] ans = o.reconstructQueue(people);
        assertArrayEquals(expected, ans);
    }

    @Test
    void test2() {
        int[][] people = new int[][]{
                {6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}
        };
        int[][] expected = new int[][]{
                {4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}
        };
        int[][] ans = o.reconstructQueue(people);
        assertArrayEquals(expected, ans);
    }
}
