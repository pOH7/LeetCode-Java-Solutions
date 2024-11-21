package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Easy
public class P0459_Repeated_Substring_Pattern {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "abab";
        assertTrue(solution.repeatedSubstringPattern(s));
    }

    interface Solution {
        public boolean repeatedSubstringPattern(String s);
    }

    // 7 ms Beats 94.55%
    class Solution1 implements Solution {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            int[] lps = buildLPS(s);
            int pattern = s.length() - lps[s.length() - 1];
            return pattern < s.length() && s.length() % pattern == 0;
        }

        int[] buildLPS(String s) {
            int[] lps = new int[s.length()];
            int i = 1;
            int length = 0;
            while (i < s.length()) {
                if (s.charAt(i) == s.charAt(length)) {
                    length++;
                    lps[i] = length;
                    i++;
                } else if (length > 0) {
                    length = lps[length - 1];
                } else {
                    i++;
                }
            }
            return lps;
        }
    }
}
