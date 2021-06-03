package pers.vv.study.jdk.proxy;

import pers.vv.study.common.Utils;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        Utils.sleep(1000 * 2);
        System.out.println("sayHello done");
    }
}
