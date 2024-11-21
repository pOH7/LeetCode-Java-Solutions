package leetcode.problems.p06;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Easy
public class P0643_Maximum_Average_Subarray_I {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(solution.findMaxAverage(nums, k));
    }

    interface Solution {
        public double findMaxAverage(int[] nums, int k);
    }

    // 4 ms Beats 68.47%
    class Solution1 implements Solution {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            int currentSum = 0;
            int maxSum = Integer.MIN_VALUE;
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                currentSum += nums[right];
                if (right - left + 1 > k) {
                    currentSum -= nums[left];
                    left++;
                }
                if (right - left + 1 == k) {
                    maxSum = Math.max(maxSum, currentSum);
                }
                right++;
            }

            return maxSum / (double) k;
        }
    }
}
