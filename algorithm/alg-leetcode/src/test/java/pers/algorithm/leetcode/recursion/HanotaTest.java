package pers.algorithm.leetcode.recursion;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HanotaTest {

    private final Hanota o = new Hanota();

    @Test
    void test1() {
        List<Integer> a = Lists.newArrayList(3, 2, 1);
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        o.hanota(a, b, c);
        System.out.println(c);
    }
}
