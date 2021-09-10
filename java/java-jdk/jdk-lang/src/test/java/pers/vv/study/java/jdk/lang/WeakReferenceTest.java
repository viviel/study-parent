package pers.vv.study.java.jdk.lang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pers.vv.study.common.Utils;

import java.lang.ref.WeakReference;

/**
 * 参数
 * -Xmx20m -Xms20m -Xmn10M -XX:+PrintCommandLineFlags -verbose:gc -XX:+PrintGCDetails
 * <p>
 * -XX:+PrintCommandLineFlags     打印jvm参数信息
 * -Xmx20M	                      设置堆最大大小20M
 * -Xms20M	                      设置堆初始大小20M
 * -Xmn10M	                      设置堆中 new Generation 新生代的大小为10M
 * -verbose:gc	                  显示GC的情况
 * -XX:+PrintGCDetails            输出GC的详细日志
 * -XX:ServivorRatio=8            设置 New Generation新生代中的 Eden区与Servivor区比例是8：1
 * -XX:+UseSerialGC               设置GC回收器模式是串型垃圾回收器
 */
public class WeakReferenceTest {

    private static class Ref extends WeakReference<Object> {

        public Ref(Object referent) {
            super(referent);
        }
    }

    private Ref ref;

    @BeforeEach
    void setUp() {
        ref = new Ref(new Object());
    }

    @Test
    void test1() {
        Utils.cachedThreadPool().execute(() -> {
            Utils.sleep(2000);
            System.gc();
        });
        while (!Thread.interrupted()) {
            for (int i = 0; i < 128 * 1024; i++) {
                Object discard = new Object();
            }
            System.out.println(ref.get());
            Utils.sleep(500);
        }
    }
}
