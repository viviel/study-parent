package pers.vv.study.jvm.memory;

public class MemoryModel2 extends MemoryModel {

    private final int[] a = new int[1];

    @Override
    public void set() {
        a[0] = 1;
    }

    @Override
    public void exe() {
        System.out.println("[exe] start");
        while (running()) {
            // 注意，println()方法会加锁，所以照常结束
            // System.out.println(a);
        }
        System.out.println("[exe] end");
    }

    private boolean running() {
        return a[0] == 0;
    }
}
