package pers.vv.study.jdk.syntax;

import java.util.concurrent.TimeUnit;

public class MInterrupted {

    public static void main(String[] args) throws InterruptedException {
        MInterrupted m = new MInterrupted();
        new Thread(m::testWait, "thread2").start();
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
