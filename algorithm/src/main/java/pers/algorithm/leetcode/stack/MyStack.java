package pers.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * <p>
 * MyStack obj = new MyStack();
 * <p>
 * obj.push(x);
 * <p>
 * int param_2 = obj.pop();
 * <p>
 * int param_3 = obj.top();
 * <p>
 * boolean param_4 = obj.empty();
 * <p>
 * <p>
 * 使用队列实现栈的下列操作：
 * <p>
 * push(x) -- 元素 x 入栈
 * <p>
 * pop() -- 移除栈顶元素
 * <p>
 * top() -- 获取栈顶元素
 * <p>
 * empty() -- 返回栈是否为空
 * <p>
 * 注意:
 * <p>
 * 你只能使用队列的基本操作-- 也就是push to back, peek/pop from front, size, 和is empty这些操作是合法的。
 * <p>
 * 你所使用的语言也许不支持队列。你可以使用 list 或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * <p>
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MyStack {

    private final Queue<Integer> queue1;

    private final Queue<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
        } else {
            queue1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        } else {
            while (queue2.size() != 1) {
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        int r = 0;
        if (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                if (queue1.size() == 1) {
                    r = queue1.element();
                }
                queue2.add(queue1.poll());
            }
        } else {
            while (!queue2.isEmpty()) {
                if (queue2.size() == 1) {
                    r = queue2.element();
                }
                queue1.add(queue2.poll());
            }
        }
        return r;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

}
