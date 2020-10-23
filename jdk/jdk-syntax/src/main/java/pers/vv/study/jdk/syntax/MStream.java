package pers.vv.study.jdk.syntax;

import java.util.Collection;
import java.util.Collections;

/**
 * java stream流原理：
 * <li><a href="https://blog.csdn.net/lcgoing/article/details/87918010">深入理解Java8中Stream的实现原理</a></li>
 */
public class MStream {

    public static void main(String[] args) {

    }

    private void test1() {
        Collection<Object> c = Collections.singletonList(this);
        c.stream()
         .map(Object::toString)
         .forEach(System.out::println);
    }

}
