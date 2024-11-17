package leetcode.problems.p06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhanglei
 * @version 11/17/24
 */
@Medium
public class P0621_Task_Scheduler {
    @Test
    void test1() {
        Solution solution = new Solution1();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        assertEquals(8, solution.leastInterval(tasks, n));
    }

    interface Solution {
        public int leastInterval(char[] tasks, int n);
    }

    // 2 ms Beats 99.37%
    class Solution1 implements Solution {
        @Override
        public int leastInterval(char[] tasks, int n) {
            int[] freq = new int[26];
            for (char task : tasks) {
                freq[task - 'A']++;
            }
            Arrays.sort(freq);
            int maxFreq = freq[25];
            // need some slots between tasks
            int slots = (maxFreq - 1) * n;
            for (int i = 24; i >= 0; i--) {
                // try to fill the slots
                if (freq[i] == maxFreq) {
                    slots -= maxFreq - 1;
                } else {
                    slots -= freq[i];
                }
                // all slots are used
                if (slots <= 0) {
                    slots = 0;
                    break;
                }
            }
            return tasks.length + slots;
        }
    }
}
