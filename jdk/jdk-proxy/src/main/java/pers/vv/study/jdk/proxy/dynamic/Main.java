package pers.vv.study.jdk.proxy.dynamic;

import pers.vv.study.jdk.proxy.HelloImpl;
import pers.vv.study.jdk.proxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Hello hello = new HelloImpl();

        InvocationHandler handler = new ProxyHandler(hello);

        Hello proxyHello = (Hello) Proxy.newProxyInstance(
                hello.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler
        );

        proxyHello.sayHello();
    }

}
