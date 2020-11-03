package pers.vv.study.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Utils {

    private final static ExecutorService executor = Executors.newCachedThreadPool();

    public static void sleep(long milliseconds) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(milliseconds);
    }

    public static ExecutorService cachedThreadPool() {
        return executor;
    }

}
