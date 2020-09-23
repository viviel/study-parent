package pers.vv.study.jdk.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentMap<Object, Object> map = new ConcurrentHashMap<>();
        map.put(1, "vv");
        map.get(1);
    }

}
