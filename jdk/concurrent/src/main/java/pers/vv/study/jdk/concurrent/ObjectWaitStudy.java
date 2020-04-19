package pers.vv.study.jdk.concurrent;

public class ObjectWaitStudy {

    private final Object object = new Object();

    public static void main(String[] args) {
        new ObjectWaitStudy().m1();
    }

    public void m1() {
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
