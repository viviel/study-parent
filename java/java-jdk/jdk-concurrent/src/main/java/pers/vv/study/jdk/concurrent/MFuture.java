package pers.vv.study.jdk.concurrent;

import pers.vv.study.common.Utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MFuture o = new MFuture();
        o.run();
    }

    private void run() throws ExecutionException, InterruptedException {
        Future<?> future = Utils.cachedThreadPool().submit(() -> {
            try {
                Utils.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.get();
    }
}
