package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Medium
public class P0287_Find_the_Duplicate_Number {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 3, 4, 2, 2};
        assertEquals(2, solution.findDuplicate(nums));
    }

    interface Solution {
        public int findDuplicate(int[] nums);
    }

    // 5 ms Beats 64.73%
    class Solution1 implements Solution {
        @Override
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
