package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/25
 */
@Medium
public class P0033_Search_in_Rotated_Sorted_Array {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        assertEquals(4, solution.search(nums, target));
    }

    interface Solution {
        public int search(int[] nums, int target);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] == target) {
                    return mid;
                    // left part is sorted
                } else if (nums[mid] >= nums[left]) {
                    // if target in the sorted left part
                    if (nums[left] <= target && target < nums[mid]) {
                        // search left part
                        right = mid - 1;
                    } else {
                        // else search right part
                        left = mid + 1;
                    }
                } else if (nums[mid] <= nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
