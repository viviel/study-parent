package pers.algorithm.leetcode.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NetworkDelayTimeTest {

    private NetworkDelayTime o;

    @BeforeEach
    void setUp() {
        o = new NetworkDelayTime();
    }

    /**
     * |      1
     * |    4/ 1\
     * |   2     3
     * |   4\  1/
     * |     4
     */
    @Test
    void test1() {
        int r = o.networkDelayTime(new int[][]{{1, 2, 4}, {1, 3, 1}, {2, 4, 4}, {3, 4, 1}}, 4, 1);
        assertEquals(4, r);
    }
}
