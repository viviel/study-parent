package pers.vv.study.jdk.proxy.dynamic;

import pers.vv.study.jdk.proxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyObject implements Hello {

    private final InvocationHandler handler;

    public ProxyObject(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void m1() {
        try {
            Method method = this.getClass().getInterfaces()[0].getDeclaredMethod("m1");
            handler.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void m2() {
        try {
            Method method = this.getClass().getInterfaces()[0].getDeclaredMethod("m2");
            handler.invoke(this, method, null);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
