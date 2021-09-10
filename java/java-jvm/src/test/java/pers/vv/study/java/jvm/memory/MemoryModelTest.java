package pers.vv.study.java.jvm.memory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

class MemoryModelTest {

    private MemoryModel o;

    @BeforeEach
    void setUp() {
        o = new MemoryModel2();
    }

    @Test
    void test1() {
        Utils.cachedThreadPool().execute(() -> o.exe());
        Utils.sleep(1000);
        o.set();
        Utils.block();
    }

    @Test
    void test2() {
        Utils.cachedThreadPool().execute(() -> {
            o.set();
            Utils.block();
        });
        Utils.cachedThreadPool().execute(() -> {
            Utils.sleep(1000);
            if (!o.get()) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
        });
        Utils.sleep(2000);
    }
}
