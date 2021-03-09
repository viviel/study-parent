package pers.vv.study.jdk.syntax;

import lombok.Data;

@Data
public class Packing {

    // 装箱 调用了 Integer.valueOf(2)
    private Integer i = 2;

    // 拆箱 调用了 i.intValue()
    private int j = i;
}
