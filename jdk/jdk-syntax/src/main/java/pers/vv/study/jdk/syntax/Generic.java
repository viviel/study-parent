package pers.vv.study.jdk.syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/105602087
 */
public class Generic {

    public static void main(String[] args) {
    }

    public static <T extends Comparable<? super T>> T min(List<T> list) {
        Collections.sort(list);
        return list.get(0);
    }

    public static <T extends Fruit> T max(List<T> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    public static void test1() {
    }

    public static void test2() {
        List<Apple> l = new ArrayList<>();
        l.add(new Apple());
//        test3(l);
//        test4(l);
//        test5(l);
    }

    public static void test3(List<Fruit> arg) {
        arg.add(new Apple());
    }

    public static void test4(List<? extends Fruit> arg) {
//        arg.add(new Apple());
    }

    public static <T extends Fruit> void test5(List<T> arg) {
//        arg.add(new Fruit());
//        arg.add(new Apple());
    }

    public static void test6(List<? super Apple> arg) {
//        arg.add(new Fruit());
        arg.add(new Apple());
    }

    public static <T> void test7(Class<T> arg) {
//        Class<String> c1 = String.class;
//        Class<?> c2 = Class.forName("java.lang.String");
    }

}

class Fruit implements Comparable<Fruit> {

    @Override
    public int compareTo(Fruit o) {
        return 0;
    }

}

class Apple extends Fruit {
}

class Orange extends Fruit {
}
