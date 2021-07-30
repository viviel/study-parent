package pers.algorithm.leetcode.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsPossibleDivideTest {

    private IsPossibleDivide o;

    @BeforeEach
    void setUp() {
        o = new IsPossibleDivide();
    }

    @Test
    void test1() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        System.out.println(map.firstKey());
        map.remove(1);
        System.out.println(map.firstKey());
    }

    @Test
    void test2() {
        int[] p = new int[]{1, 2, 3, 3, 4, 4, 5, 6};
        boolean r = o.isPossibleDivide(p, 4);
        assertTrue(r);
    }

    @Test
    void test3() {
        int[] p = new int[]{3, 3, 2, 2, 1, 1};
        boolean r = o.isPossibleDivide(p, 3);
        assertTrue(r);
    }

    @Test
    void test4() {
        int[] p = new int[]{1, 2, 3, 4};
        boolean r = o.isPossibleDivide(p, 3);
        assertFalse(r);
    }
}
