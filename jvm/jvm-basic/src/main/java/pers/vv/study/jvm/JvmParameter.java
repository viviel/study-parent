package pers.vv.study.jvm;

import pers.vv.study.common.Utils;

/**
 * 参数
 * -Xmx20m -Xms20m -Xmn10M -XX:+PrintCommandLineFlags -verbose:gc -XX:+PrintGCDetails
 * <p>
 * -Xmx20M	                      设置堆最大大小20M
 * -Xms20M	                      设置堆初始大小20M
 * -Xmn10M	                      设置堆中 new Generation 新生代的大小为10M
 * -XX:ServivorRatio=8            设置 New Generation新生代中的 Eden区与Servivor区比例是8：1
 * -XX:+PrintCommandLineFlags     打印jvm参数信息
 * -verbose:gc	                  显示GC的情况
 * -XX:+PrintGCDetails            输出GC的详细日志
 * -XX:+UseSerialGC               设置GC回收器模式是串型垃圾回收器
 */
public class JvmParameter {

    public static void main(String[] args) {
        Utils.cachedThreadPool().execute(() -> {
            Utils.sleep(2000);
            System.gc();
        });
        while (!Thread.interrupted()) {
            for (int i = 0; i < 128 * 128; i++) {
                Object discard = new Object();
            }
            Utils.sleep(100);
        }
    }
}
