package pers.algorithm.leetcode.depth.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This is the interface that allows for creating nested lists.
 * You should not implement it, or speculate about its implementation
 * <p>
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class NestedIterator implements Iterator<Integer> {

    private final List<Integer> list = new ArrayList<>();
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        traversal(nestedList);
    }

    private void traversal(List<NestedInteger> nestedList) {
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                list.add(e.getInteger());
            } else {
                traversal(e.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        if (list.isEmpty()) {
            return false;
        }
        return index < list.size();
    }
}
