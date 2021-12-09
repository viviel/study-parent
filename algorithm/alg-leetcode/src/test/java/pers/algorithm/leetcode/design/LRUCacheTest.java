package pers.algorithm.leetcode.design;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LRUCacheTest {

    private LRUCache o;

    @BeforeEach
    void setUp() {
        o = new LRUCache(2);
    }

    @Test
    void t1() {
        o.put(1, 1);
        o.put(2, 2);
        int i = o.get(1);
        assertEquals(1, i);
        o.put(3, 3);
        int i1 = o.get(2);
        assertEquals(-1, i1);
        o.put(4, 4);
        int i2 = o.get(1);
        assertEquals(-1, i2);
        int i3 = o.get(3);
        assertEquals(3, i3);
        int i4 = o.get(4);
        assertEquals(4, i4);
    }

    @Test
    void t2() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(3);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
