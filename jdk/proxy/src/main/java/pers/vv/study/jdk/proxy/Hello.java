package pers.vv.study.jdk.proxy;

public class Hello implements HelloInterface {

    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }

}