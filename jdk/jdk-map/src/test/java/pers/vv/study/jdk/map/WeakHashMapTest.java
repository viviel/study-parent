package pers.vv.study.jdk.map;

import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

public class WeakHashMapTest {

    @Test
    void test1() {
        WeakHashMap<String, Integer> map = new WeakHashMap<>();
        map.put("1", 1);
        map.put("2", 1);
        map.put("3", 1);
        System.out.println(map);
    }
}
