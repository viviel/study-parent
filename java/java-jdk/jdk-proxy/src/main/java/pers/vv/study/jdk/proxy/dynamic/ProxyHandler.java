package pers.vv.study.jdk.proxy.dynamic;

import com.google.common.base.Stopwatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private final Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Stopwatch sw = Stopwatch.createStarted();
        Object r = method.invoke(object, args);
        sw.stop();
        System.out.printf("%s: %s\n", method.getName(), sw);
        return r;
    }
}
