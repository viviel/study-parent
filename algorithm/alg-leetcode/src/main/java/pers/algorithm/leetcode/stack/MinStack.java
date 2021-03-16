package pers.algorithm.leetcode.stack;

import java.util.Arrays;

/**
 * Your MinStack object will be instantiated and called as such:
 * <p>
 * MinStack obj = new MinStack();
 * <p>
 * obj.push(x);
 * <p>
 * obj.pop();
 * <p>
 * int param_3 = obj.top();
 * <p>
 * int param_4 = obj.getMin();
 * <p>
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()—— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * <p>
 * 输入：
 * <p>
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * <p>
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * <p>
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * <p>
 * MinStack minStack = new MinStack();
 * <p>
 * minStack.push(-2);
 * <p>
 * minStack.push(0);
 * <p>
 * minStack.push(-3);
 * <p>
 * minStack.getMin();   --> 返回 -3.
 * <p>
 * minStack.pop();
 * <p>
 * minStack.top();      --> 返回 0.
 * <p>
 * minStack.getMin();   --> 返回 -2.
 *
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/min-stack
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinStack {

    private int minValue;

    private int top;

    private final int tail;

    private int[] entities;

    private int capacity = 1 << 4;

    private final static int MAX_CAPACITY = 1 << 30;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minValue = Integer.MAX_VALUE;
        top = 0;
        tail = 1;
        entities = new int[capacity];
    }

    public void push(int x) {
        if (top == capacity - 1) {
            refresh();
        }
        entities[++top] = x;
        setSize(getSize() + 1);
        if (minValue > x) {
            minValue = x;
        }
    }

    private void refresh() {
        if (capacity == MAX_CAPACITY) {
            throw new RuntimeException();
        }
        int[] a = entities;
        entities = Arrays.copyOf(a, (capacity <<= 1));
    }

    public void pop() {
        if (top == tail - 1) {
            throw new RuntimeException();
        }
        top--;
        setSize(getSize() - 1);
        minValue = getMinValue();
    }

    private int getMinValue() {
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i <= getSize(); i++) {
            if (entities[i] < temp) {
                temp = entities[i];
            }
        }
        return temp;
    }

    public int top() {
        if (getSize() == 0) {
            throw new RuntimeException();
        }
        return entities[top];
    }

    public int min() {
        if (getSize() == 0) {
            throw new RuntimeException();
        }
        return minValue;
    }

    private void setSize(int size) {
        entities[0] = size;
    }

    private int getSize() {
        return entities[0];
    }

}
