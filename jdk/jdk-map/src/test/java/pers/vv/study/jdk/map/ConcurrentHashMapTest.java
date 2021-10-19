package pers.vv.study.jdk.map;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.ArrayList;
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
//        Utils.cachedThreadPool().submit(runnable(map));
        Utils.sleep(Integer.MAX_VALUE);
    }

    private Runnable runnable(ConcurrentHashMap<Key, String> map) {
        return () -> {
            for (int i = 0; i < 16 << 10; i++) {
                map.put(new Key(1), "vv");
                map.put(new Key(i), "vv");
            }
            int size = map.size();
            System.out.println(size);
        };
    }

    /**
     * https://bugs.openjdk.java.net/browse/JDK-8161372
     * <p>
     * 测试computeIfAbsent
     * jdk1.8  测试两次，平均39
     * jdk9    测试两次，平均17
     * <p>
     * 代码改动点较少，改动代码逻辑未知
     */
    @Test
    void test2() throws InterruptedException {
        int MAP_SIZE = 20;
        int THREADS = 20;
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i < MAP_SIZE; i++) map.put(i, i);

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREADS; i++) {
            Thread t = new Thread(() -> {
                int n = 0;
                int result = 0;
                while (result < Integer.MAX_VALUE >> 1) {
                    n = (n + 1) % MAP_SIZE;
                    result += map.computeIfAbsent(n, (key) -> key + key);
                }
            });
            threads.add(t);
            t.start();
        }
        threads.get(0).join();
    }
}
