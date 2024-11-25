package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Medium
public class P0424_Longest_Repeating_Character_Replacement {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "ABAB";
        int k = 2;
        assertEquals(4, solution.characterReplacement(s, k));
    }

    interface Solution {
        public int characterReplacement(String s, int k);
    }

    // 19 ms Beats 39.89%
    class Solution1 implements Solution {
        @Override
        public int characterReplacement(String s, int k) {
            int[] window = new int[26];
            int maxLength = 0;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                window[s.charAt(right) - 'A']++;
                while (getWindowK(window) > k) {
                    window[s.charAt(left) - 'A']--;
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }

            return maxLength;
        }

        int getWindowK(int[] window) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, window[i]);
                sum += window[i];
            }

            return sum - max;
        }
    }
}
