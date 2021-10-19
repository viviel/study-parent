package pers.vv.study.jdk.proxy.statics;

import org.junit.jupiter.api.Test;
import pers.vv.study.jdk.proxy.Hello;
import pers.vv.study.jdk.proxy.HelloImpl;

class HelloProxyTest {

    @Test
    void test1() {
        Hello hello = upstream();
        Hello helloProxy = proxy(hello);
        downstream(helloProxy);
    }

    private Hello upstream() {
        return new HelloImpl();
    }

    private Hello proxy(Hello arg) {
        return new HelloProxy(arg);
    }

    private void downstream(Hello arg) {
        arg.m1();
    }
}
