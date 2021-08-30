package pers.algorithm.leetcode.division.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchInsertTest {

    private final SearchInsert o = new SearchInsert();

    @Test
    void test1() {
        assertEquals(2, o.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, o.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, o.searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(0, o.searchInsert(new int[]{1, 3, 5, 6}, 0));
        assertEquals(1, o.searchInsert(new int[]{1, 3}, 2));
    }
}