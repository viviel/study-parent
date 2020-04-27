package pers.vv.study.jdk.proxy.statics;

import pers.vv.study.jdk.proxy.HelloInterface;

public class Main {

    public static void main(String[] args) {
        HelloInterface helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }

}
