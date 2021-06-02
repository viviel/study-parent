package pers.vv.study.jdk.proxy.statics;

import pers.vv.study.jdk.proxy.Hello;

public class HelloProxy implements Hello {

    private Hello hello;

    public HelloProxy(Hello arg) {
        this.hello = arg;
    }

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        hello.sayHello();
        System.out.println("After invoke sayHello");
    }
}
