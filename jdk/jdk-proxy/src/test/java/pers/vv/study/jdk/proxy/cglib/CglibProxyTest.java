package pers.vv.study.jdk.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.jupiter.api.Test;
import pers.vv.study.jdk.proxy.HelloImpl;

class CglibProxyTest {

    @Test
    void test1() {
        System.getProperties().setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "target/classes/cglib/");
        HelloImpl hello = upstream();
        HelloImpl helloProxy = proxy(hello);
        downstream(helloProxy);
    }

    private HelloImpl upstream() {
        return new HelloImpl(2);
    }

    private HelloImpl proxy(HelloImpl hello) {
        MethodInterceptor interceptor = new SimpleMethodInterceptor(hello);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(hello.getClass());
        enhancer.setCallback(interceptor);
        Object o = enhancer.create();
        return (HelloImpl) o;
    }

    private void downstream(HelloImpl arg) {
        arg.m1();
    }
}
