package pers.vv.study.jdk.concurrent;

import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    /**
     * 对于Thread来说，只有两种方式来执行自己的代码
     * - 继承Thread，实现run()方法
     * - 实现Runnable接口，将实例传给Thread对象
     */
    @Test
    void test1() throws InterruptedException {
        Thread t = new Thread(() -> System.out.println("my running")) {
            @Override
            public void run() {
//                super.run();
                System.out.println("vv");
            }
        };
        t.start();
        t.join();
    }

    /**
     * 这种方法使用的是上面提到的第二种方法。
     * 即：FutureTask实现Runnable接口
     */
    @Test
    void test2() throws InterruptedException {
        Callable<String> c = () -> "callable";
        FutureTask<String> ft = new FutureTask<>(c);
        Thread t = new Thread(ft);
        t.start();
        t.join();
    }

    @Test
    void test3() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
        t.join();
    }

    @Test
    void test4() {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
        Thread t3 = new Thread();
        Thread t4 = new Thread();
    }

    @Test
    void test5() throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        t.join();
        System.out.println(t.getState());
    }

    @Test
    void test6() throws InterruptedException {
        Thread t = new Thread(() -> Utils.sleep(1000 * 2));
        t.start();
        t.join();
    }
}
