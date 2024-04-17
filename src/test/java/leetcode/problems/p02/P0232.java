package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 *
 * @link https://leetcode.com/problems/implement-queue-using-stacks/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0232 {
    static class MyQueue {

        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        void transToPushStack() {
            while (!popStack.empty()) {
                pushStack.push(popStack.pop());
            }
        }

        void transToPopStack() {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }

        public void push(int x) {
            transToPushStack();
            pushStack.push(x);
        }

        public int pop() {
            transToPopStack();
            return popStack.pop();
        }

        public int peek() {
            transToPopStack();
            return popStack.peek();
        }

        public boolean empty() {
            return popStack.empty() && pushStack.empty();
        }
    }

    @Test
    void test1() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, myQueue.peek()); // return 1
        assertEquals(1, myQueue.pop()); // return 1, queue is [2]
        assertFalse(myQueue.empty()); // return false
    }
}
