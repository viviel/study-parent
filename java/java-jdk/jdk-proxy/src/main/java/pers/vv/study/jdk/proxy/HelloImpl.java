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
    public void sayHello() {
        doSayHello();
    }

    private void doSayHello() {
        Utils.sleep(1000 * 2);
        System.out.printf("sign:%s\n", sign);
    }
}
