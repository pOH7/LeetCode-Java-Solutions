package leetcode.problems.p07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhanglei
 * @version 11/17/24
 */
@Medium
public class P0767_Reorganize_String {
    @Test
    void test1() {
        Solution solution = new Solution1();
        String s = "aab";
        assertNotEquals("", solution.reorganizeString(s));
        System.out.println(solution.reorganizeString(s));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        String s = "aaab";
        assertEquals("", solution.reorganizeString(s));
        System.out.println(solution.reorganizeString(s));
    }

    @Test
    void test48() {
        Solution solution = new Solution1();
        String s = "vvvlo";
        assertNotEquals("", solution.reorganizeString(s));
        System.out.println(solution.reorganizeString(s));
    }

    interface Solution {
        public String reorganizeString(String s);
    }

    // 8 ms Beats 10.22%
    class Solution1 implements Solution {
        @Override
        public String reorganizeString(String s) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Character> maxHeap =
                    new PriorityQueue<>(Comparator.comparingInt(freq::get).reversed());
            maxHeap.addAll(freq.keySet());

            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()) {
                Character c = maxHeap.poll();
                freq.put(c, freq.get(c) - 1);
                if (!sb.isEmpty()) {
                    char prev = sb.charAt(sb.length() - 1);
                    sb.append(c);
                    if (freq.get(prev) > 0) {
                        maxHeap.offer(prev);
                    }
                } else {
                    sb.append(c);
                }
            }

            return sb.length() == s.length() ? sb.toString() : "";
        }
    }
}
