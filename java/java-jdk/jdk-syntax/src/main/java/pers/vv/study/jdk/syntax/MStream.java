package pers.vv.study.jdk.syntax;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * java stream流原理：
 * <li><a href="http://cmsblogs.com/?p=15701">Java基础系列-Stream</a></li>
 * <li><a href="https://blog.csdn.net/lcgoing/article/details/87918010">深入理解Java8中Stream的实现原理</a></li>
 */
public class MStream {

    private final ArrayList<Integer> c;

    public static void main(String[] args) {
        MStream m = new MStream();
//        m.test1();
//        m.test2();
        m.test3();
    }

    public MStream() {
        c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
    }

    private void test1() {
        c.stream()
                .map(e -> e * 10)
                .filter(e -> e > 15)
                .forEach(System.out::println);
    }

    private void test2() {
        Set<String> list = c.stream()
                .map(Object::toString)
                .collect(Collectors.toSet());
    }

    private void test3() {
        Optional<String> first = c.stream()
                .map(Object::toString)
                .filter(e -> Objects.equals(e, ""))
                .findFirst();
    }
}
