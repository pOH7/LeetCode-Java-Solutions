package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Hard
public class P0239_Sliding_Window_Maximum {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        assertEquals(
                "[3,3,5,5,6,7]",
                Arrays.stream(solution.maxSlidingWindow(nums, k))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    void test21() {
        Solution solution = new Solution1();
        int[] nums = {7, 2, 4};
        int k = 2;
        assertEquals(
                "[7,4]",
                Arrays.stream(solution.maxSlidingWindow(nums, k))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")));
    }

    @Test
    void test27() {
        Solution solution = new Solution1();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        assertEquals(
                "[3,3,2,5]",
                Arrays.stream(solution.maxSlidingWindow(nums, k))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",", "[", "]")));
    }

    interface Solution {
        public int[] maxSlidingWindow(int[] nums, int k);
    }

    // 31 ms Beats 64.15%
    class Solution1 implements Solution {
        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            int right = 0;
            Deque<Integer> q = new LinkedList<>();
            int[] ans = new int[nums.length - k + 1];
            while (right < nums.length) {

                while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                    q.pollLast();
                }
                q.offerLast(right);

                while (right - q.peekFirst() + 1 > k) {
                    q.pollFirst();
                }

                if (right >= k - 1) {
                    ans[right - k + 1] = nums[q.peekFirst()];
                }
                right++;
            }
            return ans;
        }
    }

    class Solution2 implements Solution {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k <= 0) {
                return new int[0];
            }

            int n = nums.length;
            int[] result = new int[n - k + 1]; // Result array to store maximums
            Deque<Integer> deque = new LinkedList<>(); // Deque to store indices

            for (int i = 0; i < n; i++) {
                // Remove indices that are out of the bounds of the current window
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // Remove indices of smaller elements as they will never be the maximum
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                // Add current index to the deque
                deque.offerLast(i);

                // Add the maximum for the current window to the result array
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peekFirst()];
                }
            }

            return result;
        }
    }
}
