package pers.algorithm.leetcode.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class GetLeastNumbersTest {

    private final GetLeastNumbers o = new GetLeastNumbers();

    @Test
    void test1() {
        assertArrayEquals(new int[]{3, 2, 1}, o.getLeastNumbers(new int[]{1, 2, 3}, 3));
    }
}
