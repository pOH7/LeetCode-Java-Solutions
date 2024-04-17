package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 459. Repeated Substring Pattern
 *
 * @link https://leetcode.com/problems/repeated-substring-pattern/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int i = 1;
        int j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                next[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = next[j - 1];
            } else {
                i++;
            }
        }
        return next[s.length() - 1] > 0 && s.length() % (s.length() - next[s.length() - 1]) == 0;
    }

    @Test
    void test1() {
        assertTrue(repeatedSubstringPattern("abab"));
    }

    @Test
    void test2() {
        assertFalse(repeatedSubstringPattern("aba"));
    }

    @Test
    void test3() {
        assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }

    @Test
    void test4() {
        repeatedSubstringPattern("aabaaba");
    }
}
