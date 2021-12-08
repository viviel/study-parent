package pers.vv.study.jvm.memory;

public class MemoryModel {

    private boolean a = true;

    public void set() {
        a = false;
    }

    public boolean get() {
        return a;
    }

    public void exe() {
        System.out.println("[exe] start");
        while (running()) {
            // 注意，println()方法会加锁，所以照常结束
            // System.out.println(a);
        }
        System.out.println("[exe] end");
    }

    private boolean running() {
        return a;
    }
}
