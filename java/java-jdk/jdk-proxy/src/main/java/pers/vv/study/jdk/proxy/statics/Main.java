package pers.vv.study.jdk.proxy.statics;

import pers.vv.study.jdk.proxy.Hello;

public class Main {

    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }

}
