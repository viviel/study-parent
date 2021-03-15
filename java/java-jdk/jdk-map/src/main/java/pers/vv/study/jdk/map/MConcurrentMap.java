package pers.vv.study.jdk.map;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MConcurrentMap {

    private final int offset = 1_000_000;
//    private final int offset = 2_000_000;
//    private final int offset = 3_000_000;
//    private final int offset = 5_000_000;
//    private final int offset = 10_000_000;

    private final ConcurrentMap<Integer, String> hashMap;

    private final ConcurrentMap<Integer, String> skipListMap;

    public static void main(String[] args) {
        MConcurrentMap o = new MConcurrentMap();
        o.exe();
    }

    public MConcurrentMap() {
        hashMap = new ConcurrentHashMap<>();
        skipListMap = new ConcurrentSkipListMap<>();
    }

    private void exe() {
        exe(hashMap);
        exe(skipListMap);
    }

    private void exe(ConcurrentMap<Integer, String> map) {
        Stopwatch sw = Stopwatch.createStarted();
//        int size = 1;
//        int size = 2;
//        int size = 4;
//        int size = 8;
        int size = 12;
        List<CompletableFuture<Void>> list = new ArrayList<>(size);
        ExecutorService es = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            int begin = i * offset;
            list.add(CompletableFuture.runAsync(() -> run(map, begin), es));
        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .whenComplete((e, t) -> {
                    System.out.println(sw.stop());
                    es.shutdown();
                    System.out.println("shutdown es");
                    map.clear();
                    System.out.println("clear map");
                })
                .join();
    }

    private Integer getKey(int i) {
        return i;
    }

    private void run(ConcurrentMap<Integer, String> map, int begin) {
        int end = begin + offset;
        for (int i = begin; i < end; i++) {
            map.put(getKey(i), i + "vv");
        }
    }
}
