package pers.algorithm.leetcode.pointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BagOfTokensScoreTest {

    private BagOfTokensScore o;

    @BeforeEach
    void setUp() {
        o = new BagOfTokensScore();
    }

    @Test
    void test1() {
        int[] p = new int[]{100};
        int r = o.bagOfTokensScore(p, 50);
        assertEquals(0, r);
    }

    /**
     * 令牌  正面  能量  分数
     * 0     是   50    1
     */
    @Test
    void test2() {
        int[] tokens = new int[]{100, 200};
        int p = 150;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(1, r);
    }

    /**
     * 令牌  正面  能量  分数
     * 0    是    100  1
     * 3    否    500  0
     * 1    是    300  1
     * 2    是    0    2
     */
    @Test
    void test3() {
        int[] tokens = new int[]{100, 200, 300, 400};
        int p = 200;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(2, r);
    }

    /**
     * 令牌  正面  能量  分数
     * 0     是   100   1
     * 4     否   900   0
     * 1     是   700   1
     * 2     是   400   2
     * 3     是   0     3
     */
    @Test
    void test4() {
        int[] tokens = new int[]{100, 200, 300, 400, 800};
        int p = 200;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(3, r);
    }

    /**
     * 令牌  正面  能量  分数
     * 0     是   100   1
     * 8     否   1000  0
     * 1     是   800   1
     * 2     是   500   2
     * 3     是   100   3
     * <p>
     * 0     是   100   1
     * 8     否   1000  0
     * 1     是   800   1
     * 7     否   1600  0
     */
    @Test
    void test5() {
        int[] tokens = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900};
        int p = 200;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(3, r);
    }

    @Test
    void test6() {
        int[] tokens = new int[]{26};
        int p = 51;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(1, r);
    }

    @Test
    void test7() {
        int[] tokens = new int[]{4, 24, 28, 33, 96};
        int p = 35;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(3, r);
    }

    @Test
    void test8() {
        int[] tokens = new int[]{6, 0, 39, 52, 45, 49, 59, 68, 42, 37};
        int p = 99;
        int r = o.bagOfTokensScore(tokens, p);
        assertEquals(5, r);
    }
}
