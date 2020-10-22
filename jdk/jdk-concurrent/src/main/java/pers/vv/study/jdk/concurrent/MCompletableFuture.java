package pers.vv.study.jdk.concurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MCompletableFuture {

    public static void main(String[] args) throws Exception {
        MCompletableFuture o = new MCompletableFuture();
        o.runAsync();
        o.supplyAsync();
        o.whenComplete();
    }

    public void test() {
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

}
