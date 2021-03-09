package pers.vv.study.jdk.syntax;

import lombok.Data;

@Data
public class BasicType {

    // 16
    private short s = 0;

    // 32
    private int i = 0;

    // 64
    private long l = 0L;

    // 32
    private float f = 0.0F;

    // 64
    private double d = 0.0;

    // 8
    private byte b = 'a';

    // 16
    private char c = '你';

    // ? 不确定
    private boolean bl = true;
}
