package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuildArrayTest {

    private BuildArray o;

    @BeforeEach
    void setUp() {
        o = new BuildArray();
    }

    @Test
    void test1() {
        List<String> l = new ArrayList<>();
        l.add("Push");
        l.add("Push");
        l.add("Pop");
        l.add("Push");
        int[] t = {1, 3};
        assertEquals(l, o.buildArray(t, 3));
    }

}
