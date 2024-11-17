package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 11/17/24
 */
@Medium
public class P0055_Jump_Game {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(solution.canJump(nums));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {3, 2, 1, 0, 4};
        assertFalse(solution.canJump(nums));
    }

    interface Solution {
        public boolean canJump(int[] nums);
    }

    // 1 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public boolean canJump(int[] nums) {
            int pos = nums.length - 1;
            for (int i = pos - 1; i >= 0; i--) {
                if (i + nums[i] >= pos) {
                    pos = i;
                }
            }
            return pos == 0;
        }
    }
}
