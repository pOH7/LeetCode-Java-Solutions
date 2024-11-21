package leetcode.problems.p02;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
@Medium
public class P0209_Minimum_Size_Subarray_Sum {
    @Test
    void test1() {
        Solution solution = new Solution1();
    }

    interface Solution {
        public int minSubArrayLen(int target, int[] nums);
    }

    // 1 ms Beats 99.95%
    class Solution1 implements Solution {
        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int minLength = Integer.MAX_VALUE;
            int currentSum = 0;
            while (right < nums.length) {
                currentSum += nums[right];
                while (currentSum >= target) {
                    minLength = Math.min(minLength, right - left + 1);
                    currentSum -= nums[left];
                    left++;
                }
                right++;
            }
            return minLength <= nums.length ? minLength : 0;
        }
    }
}
