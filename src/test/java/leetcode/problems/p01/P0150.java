package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * @link https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer subtrahend = stack.pop();
                    stack.push(stack.pop() - subtrahend);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }

    @Test
    void test1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        assertEquals(9, evalRPN(tokens));
    }

    @Test
    void test2() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        assertEquals(6, evalRPN(tokens));
    }

    @Test
    void test3() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, evalRPN(tokens));
    }
}
