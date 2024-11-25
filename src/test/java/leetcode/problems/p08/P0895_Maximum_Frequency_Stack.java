package leetcode.problems.p08;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhanglei
 * @version 2024/11/25
 */
@Hard
public class P0895_Maximum_Frequency_Stack {
    @Test
    void test1() {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        /**
         *
         *
         * <pre>
         *     5,5,5
         *     7,7
         *     4
         * </pre>
         */
        freqStack.pop(); // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop(); // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
        // The stack becomes [5,7,5,4].
        freqStack.pop(); // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop(); // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the
        // top. The stack becomes [5,7].
    }

    // 28 ms Beats 97.04%
    class FreqStack {
        Map<Integer, Integer> freq;
        Stack<Stack<Integer>> stack;

        public FreqStack() {
            freq = new HashMap<>();
            stack = new Stack<>();
        }

        public void push(int val) {
            int valFreq = freq.getOrDefault(val, 0) + 1;
            freq.put(val, valFreq);
            if (stack.size() < valFreq) {
                stack.push(new Stack<>());
            }
            stack.get(valFreq - 1).push(val);
        }

        public int pop() {
            Stack<Integer> peek = stack.peek();
            Integer val = peek.pop();
            if (peek.isEmpty()) {
                stack.pop();
            }
            freq.put(val, freq.getOrDefault(val, 0) - 1);
            return val;
        }
    }
}
