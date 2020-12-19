package pers.vv.study.jdk.nio.socket;

import java.util.concurrent.CountDownLatch;

/**
 * @author guoshixiong
 */
public class SocketOperator {

    static final int PORT = 8001;

    static final CountDownLatch latch = new CountDownLatch(1);
}
