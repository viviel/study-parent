package pers.vv.study.jdk.proxy;

public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }

}