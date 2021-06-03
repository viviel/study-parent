package pers.vv.study.jdk.proxy.cglib;

import com.google.common.base.Stopwatch;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SimpleMethodInterceptor implements MethodInterceptor {

    private final Object object;

    public SimpleMethodInterceptor(Object object) {
        this.object = object;
    }

    @Override
    public Object intercept(Object proxy, Method m, Object[] args, MethodProxy mp) throws Throwable {
        Stopwatch sw = Stopwatch.createStarted();
        Object r = m.invoke(object, args);
//        Object r = mp.invokeSuper(proxy, args);
        sw.stop();
        System.out.printf("%s: %s\n", m.getName(), sw);
        return r;
    }
}
