package pers.vv.study.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Utils {

    private final static ExecutorService executor = Executors.newCachedThreadPool();

    public static void sleep(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExecutorService cachedThreadPool() {
        return executor;
    }

    public static void block() {
        sleep(Integer.MAX_VALUE);
    }
}
