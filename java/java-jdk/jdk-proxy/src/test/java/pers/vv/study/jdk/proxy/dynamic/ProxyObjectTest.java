package pers.vv.study.jdk.proxy.dynamic;

class ProxyObjectTest {

    public static void main(String[] args) {
        new ProxyObjectTest().test();
    }

    private void test() {
        this.getClass().getEnclosingMethod();
    }

}