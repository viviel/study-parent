package pers.vv.study.java.design.pattern.signature;

import java.security.Signature;

public class DoubleCheck {

    private static volatile DoubleCheck s;

    private DoubleCheck() {
    }

    public static DoubleCheck getInstance() {
        if (s == null) {
            synchronized (Signature.class) {
                if (s == null) {
                    s = new DoubleCheck();
                }
            }
        }
        return s;
    }
}
