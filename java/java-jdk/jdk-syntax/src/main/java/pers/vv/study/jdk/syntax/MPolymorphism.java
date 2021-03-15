package pers.vv.study.jdk.syntax;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class MPolymorphism {

    public static void main(String[] args) {
        MPolymorphism o = new MPolymorphism();
        o.e1(new C());
        o.e2(new C());
    }

    private static class C implements Consumer<Integer>, IntConsumer {
        @Override
        public void accept(Integer integer) {
            System.out.println(integer);
        }

        @Override
        public void accept(int value) {
            System.out.println(value);
        }
    }

    private void e1(Consumer<Integer> a) {
        System.out.println("MPolymorphism.e1");
        System.out.println(a instanceof Consumer);
        System.out.println(a instanceof IntConsumer);
    }

    private void e2(IntConsumer a) {
        System.out.println("MPolymorphism.e2");
        System.out.println(a instanceof Consumer);
        System.out.println(a instanceof IntConsumer);
    }
}
