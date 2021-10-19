package pers.vv.study.jdk.util;

import java.util.BitSet;

public class MBitSet {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(10000);
        boolean sign = bitSet.get(10000);
        System.out.println(sign);
    }
}
