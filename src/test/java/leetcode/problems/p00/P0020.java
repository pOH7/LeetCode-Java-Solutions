package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 20. Valid Parentheses
 *
 * @link https://leetcode.com/problems/valid-parentheses/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.empty() || !stack.peek().equals(c)) {
                Character closedBrackets = getClosedBrackets(c);
                if (closedBrackets != null) {
                    stack.push(closedBrackets);
                } else {
                    return false;
                }
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    static Character getClosedBrackets(Character character) {
        switch (character) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return null;
    }

    @Test
    void test1() {
        assertTrue(isValid("()"));
    }

    @Test
    void test2() {
        assertTrue(isValid("()[]{}"));
    }

    @Test
    void test3() {
        assertFalse(isValid("(]"));
    }
}
