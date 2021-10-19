package pers.vv.study.jdk.proxy.dynamic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pers.vv.study.jdk.proxy.Hello;
import pers.vv.study.jdk.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class DynamicHelloProxyTest {

    @BeforeAll
    static void beforeAll() {
        //不起作用，需要使用 -Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
    }

    @Test
    void test1() {
        Hello hello = upstream();
        Hello helloProxy = proxy(hello);
        downstream(helloProxy);
    }

    private Hello upstream() {
        return new HelloImpl(3);
    }

    private Hello proxy(Hello hello) {
        InvocationHandler handler = new ProxyHandler(hello);
        return (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler
        );
    }

    private void downstream(Hello arg) {
        arg.m1();
    }
}
