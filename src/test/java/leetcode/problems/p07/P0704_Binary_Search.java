package leetcode.problems.p07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Easy
public class P0704_Binary_Search {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
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
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
}
