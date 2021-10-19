package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CompletableFutureTest {

    @Test
    void test1() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return "blog.csdn.net/zhangphil";
            }
        });

        System.out.println(System.currentTimeMillis() + ":time 1");

        future.whenCompleteAsync(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println(System.currentTimeMillis() + ":" + s);
            }
        });

        System.out.println(System.currentTimeMillis() + ":time 2");

        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (Exception e) {
//                    //异常退出。
//                    future.completeExceptionally(e);
//                }

                // CompletableFuture被通知线程任务完成。
                System.out.println(System.currentTimeMillis() + ":运行至此。");
                //使cf的任务立刻完成，如果成功，返回指定值，否则返回cf任务应有的值
                System.out.println(future.complete("任务完成。"));
            }
        }).start();

        new Thread(() -> {
            try {
                String s = future.get();
                System.out.println(s);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(System.currentTimeMillis() + ":time 3");
    }

    @Test
    void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.get();
        Utils.cachedThreadPool().execute(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ignored) {
            }
            //使cf的任务立刻完成，如果成功，返回给定值，否则返回cf任务应有的值
            cf.complete("done");
        });
    }
}
