package pers.vv.study.jdk.concurrent;

public class ObjectWaitStudy {

    private final Object object = new Object();

    private final Object o2 = new Object();

    public static void main(String[] args) {
        new ObjectWaitStudy().m1();
    }

    /**
     * 调用wait的对象必须是锁对象
     */
    public void m1() {
        try {
            synchronized (object) {
                o2.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
