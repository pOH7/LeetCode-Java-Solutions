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
class P0020_Valid_Parentheses {
    interface Solution {
        public boolean isValid(String s);
    }

    class Solution1 implements Solution {

        @Override
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i< s.length(); i++) {
                Character c = s.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case '}':
                        if(!stack.isEmpty() && stack.peek() == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            }
            return stack.isEmpty();
        }
    }

    @Test
    void test1() {
        Solution solution = new Solution1();
        assertTrue(solution.isValid("()"));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        assertFalse(solution.isValid("(]"));
    }
}
