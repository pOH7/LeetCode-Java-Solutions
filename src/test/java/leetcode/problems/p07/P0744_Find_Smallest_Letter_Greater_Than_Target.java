package leetcode.problems.p07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Easy
public class P0744_Find_Smallest_Letter_Greater_Than_Target {
    @Test
    void test1() {
        Solution solution = new Solution2();
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        assertEquals('c', solution.nextGreatestLetter(letters, target));
    }

    @Test
    void test129() {
        Solution solution = new Solution2();
        char[] letters = {'e', 'e', 'g', 'g'};
        char target = 'g';
        assertEquals('e', solution.nextGreatestLetter(letters, target));
    }

    interface Solution {
        public char nextGreatestLetter(char[] letters, char target);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;
            int minAbove = 0;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (letters[mid] == target) {
                    for (int i = mid + 1; i < letters.length; i++) {
                        if (letters[i] != letters[mid]) {
                            return letters[i];
                        }
                    }
                    return letters[0];
                } else if (letters[mid] < target) {
                    left = mid + 1;
                } else {
                    minAbove = mid;
                    right = mid - 1;
                }
            }
            return letters[minAbove];
        }
    }

    class Solution2 implements Solution {

        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;
            while (left <= right) {
                int mid = (right + left) >>> 1;
                if (letters[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return letters[left % letters.length];
        }
    }
}
