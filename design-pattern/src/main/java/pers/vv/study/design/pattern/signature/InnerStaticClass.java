package pers.vv.study.design.pattern.signature;

public class InnerStaticClass {

    private static class Holder {
        private static final InnerStaticClass o = new InnerStaticClass();
    }

    private InnerStaticClass() {
    }

    public static InnerStaticClass getInstance() {
        return Holder.o;
    }
}
