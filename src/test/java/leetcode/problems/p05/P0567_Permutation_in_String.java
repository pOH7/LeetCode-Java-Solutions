package leetcode.problems.p05;

import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Medium
public class P0567_Permutation_in_String {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s1 = "ab", s2 = "eidbaooo";
        assertTrue(solution.checkInclusion(s1, s2));
    }

    interface Solution {
        public boolean checkInclusion(String s1, String s2);
    }

    // 7 ms Beats 72.72%
    class Solution1 implements Solution {
        @Override
        public boolean checkInclusion(String s1, String s2) {
            int[] freq = new int[26];
            for (char c : s1.toCharArray()) {
                freq[c - 'a']++;
            }
            int left = 0;
            int right = 0;
            int[] window = new int[26];
            while (right < s2.length()) {
                char rightC = s2.charAt(right);
                window[rightC - 'a']++;
                while (right - left + 1 > s1.length()) {
                    window[s2.charAt(left) - 'a']--;
                    left++;
                }
                if (right - left + 1 == s1.length()) {
                    if (Arrays.equals(freq, window)) {
                        return true;
                    }
                }
                right++;
            }

            return false;
        }
    }
}
