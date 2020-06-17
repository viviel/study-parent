package pers.vv.study.common;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void sleep(long milliseconds) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(milliseconds);
    }

}
