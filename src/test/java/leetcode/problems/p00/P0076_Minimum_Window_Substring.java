package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Hard
public class P0076_Minimum_Window_Substring {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "ADOBECODEBANC", t = "ABC";
        assertEquals("BANC", solution.minWindow(s, t));
    }

    interface Solution {
        public String minWindow(String s, String t);
    }

    // 19 ms Beats 52.92%
    class Solution1 implements Solution {
        @Override
        public String minWindow(String s, String t) {
            Map<Character, Integer> freq = new HashMap<>();
            for (Character c : t.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> window = new HashMap<>();
            int minLength = Integer.MAX_VALUE;
            int startIndex = 0;
            int left = 0;
            int right = 0;
            int matchCount = 0;

            while (right < s.length()) {
                char rightC = s.charAt(right);
                window.put(rightC, window.getOrDefault(rightC, 0) + 1);

                if (freq.containsKey(rightC) && window.get(rightC).equals(freq.get(rightC))) {
                    matchCount++;
                }
                while (matchCount == freq.size()) {
                    if (right - left + 1 < minLength) {
                        minLength = right - left + 1;
                        startIndex = left;
                    }
                    char leftC = s.charAt(left);
                    window.put(leftC, window.getOrDefault(leftC, 0) - 1);
                    left++;
                    if (freq.containsKey(leftC) && window.get(leftC) < freq.get(leftC)) {
                        matchCount--;
                    }
                }
                right++;
            }
            return minLength == Integer.MAX_VALUE
                    ? ""
                    : s.substring(startIndex, startIndex + minLength);
        }
    }
}
