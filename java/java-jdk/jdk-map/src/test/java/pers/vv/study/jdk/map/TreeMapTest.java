package pers.vv.study.jdk.map;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test
    void test1() {
        new TreeMap<Integer, String>() {{
            put(1, "vv");
            put(2, "vv");
            put(3, "vv");
        }};
    }
}
