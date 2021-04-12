package pers.vv.study.jdk.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class SetTest {

    @Test
    void test1() {
        TreeSet<Value> set = new TreeSet<>(Comparator.comparing(Value::getId));
        Value v1 = new Value(1, "1");
        Value v2 = new Value(1, "2");
        set.add(v1);
        set.add(v2);
    }
}
