package pers.algorithm.leetcode.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AssignTasksTest {

    private AssignTasks o;

    @BeforeEach
    void setUp() {
        o = new AssignTasks();
    }

    @Test
    void test1() {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        int[] r = o.assignTasks(servers, tasks);
        Assertions.assertArrayEquals(new int[]{2, 2, 0, 2, 1, 2}, r);
    }

    @Test
    void test2() {
        int[] servers = {5, 1, 4, 3, 2};
        int[] tasks = {2, 1, 2, 4, 5, 2, 1};
        int[] r = o.assignTasks(servers, tasks);
        Assertions.assertArrayEquals(new int[]{1, 4, 1, 4, 1, 3, 2}, r);
    }
}
