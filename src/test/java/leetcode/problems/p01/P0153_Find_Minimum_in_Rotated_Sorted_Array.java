package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/25
 */
@Medium
public class P0153_Find_Minimum_in_Rotated_Sorted_Array {
    @Test
    void test1() {
        Solution solution = new Solution2();
        int[] nums = {3, 4, 5, 1, 2};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    void test2() {
        Solution solution = new Solution2();
        int[] nums = {2, 1};
        assertEquals(1, solution.findMin(nums));
    }

    interface Solution {
        public int findMin(int[] nums);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                }
                int mid = (left + right) >>> 1;
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    // 0 ms Beats 100.00%
    class Solution2 implements Solution {
        @Override
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                if (nums[left] < nums[right]) {
                    return nums[left];
                }
                int mid = (left + right) >>> 1;
                if (mid == left) {
                    return nums[right];
                }
                if (nums[mid] > nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return -1;
        }
    }
}
