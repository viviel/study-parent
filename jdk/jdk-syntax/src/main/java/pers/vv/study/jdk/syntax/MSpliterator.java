package pers.vv.study.jdk.syntax;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MSpliterator {

    private final IntStream stream;

    private final List<Integer> list;

    public MSpliterator() {
        stream = IntStream.range(0, 100);
        list = IntStream.range(0, 100).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        MSpliterator m = new MSpliterator();
        m.test1();
        m.test2();
    }

    private void test1() {
        Spliterator.OfInt spliterator1 = stream.spliterator();
        Spliterator.OfInt spliterator2 = spliterator1.trySplit();
        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
    }

    private void test2() {
        Spliterator<Integer> spliterator1 = list.spliterator();
        Spliterator<Integer> spliterator2 = spliterator1.trySplit();
        System.out.println(spliterator1.estimateSize());
        System.out.println(spliterator2.estimateSize());
    }

}
