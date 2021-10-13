package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    private Search o;

    @BeforeEach
    void setUp() {
        o = new Search2();
    }

    /**
     * nums = [4,5,6,7,0,1,2], target = 0
     */
    @Test
    void test1() {
    }

    /**
     * 4,5,6,7,8,9,10,0,1,2
     * <p>
     * 8
     * 9,10,0,1,2
     * <p>
     * 0
     */
    @Test
    void test2() {
    }

    /**
     * 8,9,10,0,1,2,4,5,6,7
     * <p>
     * 1
     * 8,9,10,0
     * <p>
     * 9
     * 10,0
     * <p>
     * 10
     * 0
     */
    @Test
    void test3() {
    }

    @Test
    void test4() {
        Search2 o = new Search2();
        int ans = o.findSplit(new int[]{4, 5, 6, 7, 0, 1, 2});
        assertEquals(4, ans);
    }

    @Test
    void test5() {
        Search2 o = new Search2();
        int ans = o.findSplit(new int[]{8, 9, 10, 0, 1, 2, 4, 5, 6, 7});
        assertEquals(3, ans);
    }

    @Test
    void test6() {
        Search2 o = new Search2();
        int ans = o.findTarget(new int[]{0, 1, 2, 4, 5, 6, 7}, 2, 0, 6);
        assertEquals(2, ans);
    }

    @Test
    void test7() {
        int ans = o.search(new int[]{1, 3}, 3);
        assertEquals(1, ans);
    }

    @Test
    void test8() {
        int ans = o.search(new int[]{3, 1}, 3);
        assertEquals(0, ans);
    }

    @Test
    void test9() {
        int ans = o.search(new int[]{5, 1, 3}, 5);
        assertEquals(0, ans);
    }

    /**
     * 5,1,3
     *
     * 1
     * 5,1
     *
     *
     */
    @Test
    void test10() {
        Search2 o = new Search2();
        int ans = o.findSplit(new int[]{5, 1, 3});
        assertEquals(1, ans);
    }
}
