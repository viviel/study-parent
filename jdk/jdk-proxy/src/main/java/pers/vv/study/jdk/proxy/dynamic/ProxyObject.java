package pers.vv.study.jdk.proxy.dynamic;

import pers.vv.study.jdk.proxy.Hello;

import java.lang.reflect.InvocationHandler;

public class ProxyObject implements Hello {

    private final InvocationHandler handler;

    public ProxyObject(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void sayHello() {
        try {
            handler.invoke(this, this.getClass().getEnclosingMethod(), null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
