package pers.algorithm.leetcode.queue;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

class KthLargestTest {

    @Test
    void test1() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);
        pq.offer(3);
        pq.offer(1);
        pq.offer(5);
        pq.offer(8);
        System.out.println(pq);
    }

    @Test
    void test2() {
        KthLargest o = new KthLargest(2, new int[]{6, 2, 4, 10, 2});
        System.out.println(o.add(3));
    }
}
