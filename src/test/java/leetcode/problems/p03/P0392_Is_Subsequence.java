package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0392_Is_Subsequence {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "abc", t = "ahbgdc";
        assertTrue(solution.isSubsequence(s, t));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        String s = "axc", t = "ahbgdc";
        assertFalse(solution.isSubsequence(s, t));
    }

    interface Solution {
        public boolean isSubsequence(String s, String t);
    }

    class Solution1 implements Solution {

        @Override
        public boolean isSubsequence(String s, String t) {
            int is = 0;
            for (int it = 0; is < s.length() && it < t.length(); it++) {
                if (s.charAt(is) == t.charAt(it)) {
                    is++;
                }
            }
            return is == s.length();
        }
    }
}
