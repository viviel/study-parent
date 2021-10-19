package pers.vv.study.jdk.syntax;

import pers.vv.study.common.Utils;

import java.util.concurrent.TimeUnit;

public class MInterrupted {

    public static void main(String[] args) throws InterruptedException {
        MInterrupted m = new MInterrupted();
        Utils.cachedThreadPool().submit(m::testWait);
        synchronized (m) {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        }
    }

    public void testWait() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
