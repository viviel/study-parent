package pers.vv.study.jdk.syntax;

import java.util.Spliterator;
import java.util.stream.IntStream;

public class MSpliterator {

    public static void main(String[] args) {
        MSpliterator m = new MSpliterator();
        m.test1();
    }

    private void test1() {
        IntStream stream = IntStream.range(0, 100);
        Spliterator.OfInt spliterator1 = stream.spliterator();
        Spliterator.OfInt spliterator2 = spliterator1.trySplit();
        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
    }

}
