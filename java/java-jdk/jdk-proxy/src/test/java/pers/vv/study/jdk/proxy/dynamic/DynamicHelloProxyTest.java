package pers.vv.study.jdk.proxy.dynamic;

import org.junit.jupiter.api.Test;
import pers.vv.study.jdk.proxy.Hello;
import pers.vv.study.jdk.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

class DynamicHelloProxyTest {

    @Test
    void test1() {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Hello hello = upstream();
        Hello helloProxy = proxy(hello);
        downstream(helloProxy);
    }

    private Hello upstream() {
        return new HelloImpl();
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
        arg.sayHello();
    }
}
