package pers.algorithm.leetcode.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinStackTest {

    @Test
    void test1() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(minStack.min(), -3);
        minStack.pop();
        Assertions.assertEquals(minStack.top(), 0);
        Assertions.assertEquals(minStack.min(), -2);
    }

    /**
     * ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
     * <p>
     * [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]
     */
    @Test
    void test2() {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        Assertions.assertEquals(minStack.min(), 0);
        minStack.pop();
        Assertions.assertEquals(minStack.min(), 0);
        minStack.pop();
        Assertions.assertEquals(minStack.min(), 0);
        minStack.pop();
        Assertions.assertEquals(minStack.min(), 2);
    }

}