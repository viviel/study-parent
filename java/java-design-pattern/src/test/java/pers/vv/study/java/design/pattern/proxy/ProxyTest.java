package pers.vv.study.java.design.pattern.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Random;

class ProxyTest {

    @Test
    void test1() {
        Sort sort = (Sort) Proxy.newProxyInstance(getClassLoader(), getInterfaces(), getInvocationHandler());
    }

    private ClassLoader getClassLoader() {
        return Sort.class.getClassLoader();
    }

    private Class<?>[] getInterfaces() {
        return new Class[]{Sort.class};
    }

    private InvocationHandler getInvocationHandler() {
        int i = new Random().nextInt(2);
        if (i == 0) {
            return new BubbleSortInvocationHandler();
        } else {
            return new QuickSortInvocationHandler();
        }
    }
}
