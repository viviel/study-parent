package pers.vv.study.jdk.proxy;

import pers.vv.study.common.Utils;

public class HelloImpl implements Hello {

    private int sign;

    public HelloImpl() {
    }

    public HelloImpl(int sign) {
        this.sign = sign;
    }

    @Override
    public void m1() {
        doM1();
        m2();
    }

    private void doM1() {
        Utils.sleep(1000 * 2);
        System.out.printf("sign:%s\n", sign);
    }

    @Override
    public void m2() {
        System.out.println("HelloImpl.m2");
    }
}
