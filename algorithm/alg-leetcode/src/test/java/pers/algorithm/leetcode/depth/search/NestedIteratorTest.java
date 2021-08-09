package pers.algorithm.leetcode.depth.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class NestedIteratorTest {

    @Test
    void test1() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Collections.emptyList();
            }
        });
        NestedIterator o = new NestedIterator(nestedList);
        while (o.hasNext()) {
            System.out.println(o.next());
        }
    }
}
