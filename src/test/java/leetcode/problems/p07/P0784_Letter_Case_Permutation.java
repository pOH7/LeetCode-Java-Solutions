package leetcode.problems.p07;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Medium
public class P0784_Letter_Case_Permutation {
    @Test
    void test1() {
        Solution solution = new Solution1();
        System.out.println(solution.letterCasePermutation("a1b2"));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        System.out.println(solution.letterCasePermutation("3z4"));
    }

    interface Solution {
        public List<String> letterCasePermutation(String s);
    }

    // 1 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public List<String> letterCasePermutation(String s) {
            List<String> result = new ArrayList<>();
            backtrack(s.toCharArray(), 0, result);
            return new ArrayList<>(result);
        }

        void backtrack(char[] s, int index, List<String> result) {
            if (index == s.length) {
                result.add(new String(s));
                return;
            }
            backtrack(s, index + 1, result);
            if (s[index] >= 'a' && s[index] <= 'z') {
                s[index] = Character.toUpperCase(s[index]);
                backtrack(s, index + 1, result);
                s[index] = Character.toLowerCase(s[index]);
            } else if (s[index] >= 'A' && s[index] <= 'Z') {
                s[index] = Character.toLowerCase(s[index]);
                backtrack(s, index + 1, result);
                s[index] = Character.toUpperCase(s[index]);
            }
        }
    }

    class Solution2 implements Solution {

        @Override
        public List<String> letterCasePermutation(String s) {
            List<String> result = new ArrayList<>();
            backtrack(s.toCharArray(), 0, result);
            return new ArrayList<>(result);
        }

        void backtrack(char[] s, int index, List<String> result) {
            if (index == s.length) {
                result.add(new String(s));
                return;
            }
            if (s[index] >= '0' && s[index] <= '9') {
                backtrack(s, index + 1, result);
            } else {
                s[index] = Character.toUpperCase(s[index]);
                backtrack(s, index + 1, result);
                s[index] = Character.toLowerCase(s[index]);
                backtrack(s, index + 1, result);
            }
        }
    }
}
