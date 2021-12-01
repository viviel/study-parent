package pers.algorithm.leetcode.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeKListsTest {

    private MergeKLists o;

    @BeforeEach
    void setUp() {
        o = new MergeKLists();
    }

    @Test
    void t1() {
        ListNode list1 = ListNodes.listNode(3);
        ListNode list2 = ListNodes.listNode(5);
        ListNode merge = o.merge(list1, list2);
    }
}
