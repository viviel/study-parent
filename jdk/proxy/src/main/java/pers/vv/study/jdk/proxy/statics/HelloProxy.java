package pers.vv.study.jdk.proxy.statics;

import pers.vv.study.jdk.proxy.Hello;
import pers.vv.study.jdk.proxy.HelloInterface;

public class HelloProxy implements HelloInterface {

    private final HelloInterface helloInterface = new Hello();

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }

}