package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Easy
public class P0028_Find_the_Index_of_the_First_Occurrence_in_a_String {
    @Test
    void test1() {
        Solution solution = new Solution1();
        assertEquals(2, solution.strStr("hello", "ll"));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        assertEquals(-1, solution.strStr("aaaaa", "bba"));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        assertEquals(0, solution.strStr("", ""));
    }

    interface Solution {
        public int strStr(String haystack, String needle);
    }

    // 1 ms Beats 22.88%
    class Solution1 implements Solution {
        @Override
        public int strStr(String haystack, String needle) {
            if (needle.isEmpty()) {
                return 0;
            }
            int[] lps = computeLPS(needle);
            int i = 0;
            int j = 0;
            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                    if (j == needle.length()) {
                        return i - j;
                    }
                } else if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

            return -1;
        }

        int[] computeLPS(String needle) {
            int[] lps = new int[needle.length()];
            int i = 1;
            int length = 0;
            while (i < needle.length()) {
                if (needle.charAt(i) == needle.charAt(length)) {
                    length++;
                    lps[i] = length;
                    i++;
                } else {
                    if (length > 0) {
                        length = lps[length - 1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }
    }
}
