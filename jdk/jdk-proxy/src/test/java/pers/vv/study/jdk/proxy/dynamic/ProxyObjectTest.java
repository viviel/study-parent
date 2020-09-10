package pers.vv.study.jdk.proxy.dynamic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ProxyObjectTest {

    public static void main(String[] args) {
        new ProxyObjectTest().test();
    }

    private void test() {
        this.getClass().getEnclosingMethod();
    }

}