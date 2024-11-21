package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Medium
public class P0003_Longest_Substring_Without_Repeating_Characters {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "abcabcbb";
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    @Test
    void test566() {
        Solution solution = new Solution1();
        String s = "aabaab!bb";
        assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    interface Solution {
        public int lengthOfLongestSubstring(String s);
    }

    // 5 ms Beats 87.29%
    class Solution1 implements Solution {
        @Override
        public int lengthOfLongestSubstring(String s) {
            int left = 0;
            int right = 0;
            int maxLength = 0;
            Set<Character> window = new HashSet<>();
            while (right < s.length()) {
                char rightC = s.charAt(right);
                if (window.contains(rightC)) {
                    while (left < right) {
                        char leftC = s.charAt(left);
                        left++;
                        if (leftC == rightC) {
                            break;
                        } else {
                            window.remove(leftC);
                        }
                    }
                } else {
                    window.add(rightC);
                    maxLength = Math.max(maxLength, window.size());
                }
                right++;
            }

            return maxLength;
        }
    }
}
