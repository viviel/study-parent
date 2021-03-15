package pers.vv.study.jdk.concurrent;

import com.google.common.base.Stopwatch;
import pers.vv.study.common.Utils;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MCompletableFuture {

    public static void main(String[] args) throws Exception {
        MCompletableFuture o = new MCompletableFuture();
//        o.runAsync();
//        o.supplyAsync();
//        o.whenComplete();
        o.example1();
    }

    public void example() {
        Runnable runnable = () -> {
        };
        Supplier<Integer> supplier = () -> 0;
        Executor executor = ForkJoinPool.commonPool();

        CompletableFuture.allOf();
        CompletableFuture.anyOf();
        CompletableFuture.runAsync(runnable);
        CompletableFuture.runAsync(runnable, executor);
        CompletableFuture.supplyAsync(supplier);
        CompletableFuture.supplyAsync(supplier, executor);
        CompletableFuture.completedFuture(null);
    }

    //无返回值
    public void runAsync() throws Exception {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {
            }
            System.out.println("[runAsync] run end ...");
        });
        future.get();
    }

    //有返回值
    public void supplyAsync() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {
            }
            System.out.println("[supplyAsync] run end ...");
            return System.currentTimeMillis();
        });
        long time = future.get();
        System.out.println("time = " + time);
    }

    public void whenComplete() throws Exception {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ignored) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println("run end ...");
            return 1;
        });
        future.whenComplete((r, throwable) -> System.out.println("执行完成！"));
        future.exceptionally(throwable -> {
            System.out.println("执行失败！" + throwable.getMessage());
            return null;
        });
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 场景：多个独立io操作时可以使用cf
     */
    public void example1() {
        Stopwatch sw = Stopwatch.createStarted();
        doExample1();
        System.out.println(sw.stop());
    }

    private void doExample1() {
        CompletableFuture<Integer> f1 = CompletableFuture
                .supplyAsync(this::http1)
                .thenApplyAsync(this::dealHttp1Result);
        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(this::http2);
        CompletableFuture<Integer> f3 = CompletableFuture.supplyAsync(this::http2);
        CompletableFuture.allOf(f1, f2, f3).thenAccept(v -> {
            int def = 0;
            deal(f1.getNow(def), f2.getNow(def), f3.getNow(def));
        });
    }

    private int http1() {
//        try {
//            Utils.sleep(1000 * 2);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("http1 " + Thread.currentThread());
        return 1;
    }

    private int dealHttp1Result(Integer i) {
        try {
            Utils.sleep(1000 * 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("dealHttp1Result " + Thread.currentThread());
        return ++i;
    }

    private int http2() {
        try {
            Utils.sleep(1000 * 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 2;
    }

    private void deal(int r1, int r2, int r3) {
        System.out.println("r1 = " + r1 + ", r2 = " + r2 + ", r3 = " + r3);
    }
}
