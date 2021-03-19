package pers.vv.study.jdk.map;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapTest {

    @AllArgsConstructor
    private static class Key {

        private final int hash;

        @Override
        public int hashCode() {
            return hash;
        }
    }

    @Test
    void test1() throws InterruptedException {
        ConcurrentHashMap<Key, String> map = new ConcurrentHashMap<>();
        Utils.cachedThreadPool().submit(runnable(map));
        Utils.cachedThreadPool().submit(runnable(map));
        Utils.sleep(Integer.MAX_VALUE);
    }

    private Runnable runnable(ConcurrentHashMap<Key, String> map) {
        return () -> {
            for (int i = 0; i < 64; i++) {
                map.put(new Key(1), "vv");
                map.put(new Key(i), "vv");
            }
            int size = map.size();
            System.out.println(size);
        };
    }
}