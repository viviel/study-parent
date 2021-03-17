package pers.vv.study.jdk.map;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

class ConcurrentMapTest {

    @Test
    void test1() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("vv", 1);
        int size = map.size();
        System.out.println(size);
    }
}