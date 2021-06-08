package pers.vv.study.jdk.proxy.statics;

import pers.vv.study.jdk.proxy.Hello;

public class HelloProxy implements Hello {

    private final Hello hello;

    public HelloProxy(Hello arg) {
        this.hello = arg;
    }

    @Override
    public void m1() {
        System.out.println("[Before] HelloProxy.m1");
        hello.m1();
        System.out.println("[After] HelloProxy.m1");
    }

    @Override
    public void m2() {
        System.out.println("[Before] HelloProxy.m2");
        hello.m2();
        System.out.println("[After] HelloProxy.m2");
    }
}
