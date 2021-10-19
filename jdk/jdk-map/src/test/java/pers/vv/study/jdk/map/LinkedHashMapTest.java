package pers.vv.study.jdk.map;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    @Test
    void test1() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        System.out.println(map);
    }

    /**
     * LRU缓存
     */
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private static final int MAX_ENTRIES = 3;

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > MAX_ENTRIES;
        }

        LRUCache() {
            super(MAX_ENTRIES, 0.75f, true);
        }
    }
}
