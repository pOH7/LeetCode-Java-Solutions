package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * @link https://leetcode.com/problems/implement-stack-using-queues/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0225 {
    static class MyStack {

        Queue<Integer> queue;
        Queue<Integer> tempQueue;

        public MyStack() {
            queue = new ArrayDeque<>();
            tempQueue = new ArrayDeque<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            while (queue.size() > 1) {
                tempQueue.offer(queue.poll());
            }
            int result = queue.poll();
            Queue<Integer> t = queue;
            queue = tempQueue;
            tempQueue = t;
            return result;
        }

        public int top() {
            while (queue.size() > 1) {
                tempQueue.offer(queue.poll());
            }
            int result = queue.poll();
            tempQueue.offer(result);
            Queue<Integer> t = queue;
            queue = tempQueue;
            tempQueue = t;
            return result;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    @Test
    void test1() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top()); // return 2
        assertEquals(2, myStack.pop()); // return 2
        assertFalse(myStack.empty()); // return False
    }
}
