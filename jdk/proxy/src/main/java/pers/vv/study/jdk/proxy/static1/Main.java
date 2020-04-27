package pers.vv.study.jdk.proxy.static1;

import pers.vv.study.jdk.proxy.HelloInterface;

public class Main {

    public static void main(String[] args) {
        HelloInterface helloProxy = new HelloProxy();
        helloProxy.sayHello();
    }

}
