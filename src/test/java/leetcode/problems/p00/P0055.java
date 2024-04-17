package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 55. Jump Game
 *
 * @link https://leetcode.com/problems/jump-game/
 * @author zhanglei
 * @date 2022/4/26
 */
class P0055 {

    public boolean canJump(int[] nums) {
        int currentStepEnd = 0;
        int nextStepCanReach = 0;
        for (int i = 0; i < nums.length; i++) {
            nextStepCanReach = Math.max(nextStepCanReach, nums[i] + i);
            if (nextStepCanReach >= nums.length - 1) {
                return true;
            }
            if (i == currentStepEnd) {
                if (nextStepCanReach > currentStepEnd) {
                    currentStepEnd = nextStepCanReach;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /*
    // O(n)
    public boolean canJump(int[] nums) {
        int shouldJumpTo = nums.length - 1;
        for (int start = nums.length - 2; start >= 0; start--) {
            if (nums[start] >= shouldJumpTo - start) {
                shouldJumpTo = start;
            }
        }
        return nums[0] >= shouldJumpTo;
    }
    */

    /*
    public boolean canJump(int[] nums) {
        return canJump(nums, 0, new boolean[nums.length]);
    }

    boolean canJump(int[] nums, int start, boolean[] skip) {
        if (start >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i <= nums[start]; i++) {
            if (skip[start + i]) {
                continue;
            }
            if (canJump(nums, start + i, skip)) {
                return true;
            } else {
                skip[start + i] = true;
            }
        }
        skip[start] = true;
        return false;
    }
    */

    @Test
    void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        assertTrue(canJump(nums));
    }

    @Test
    void test2() {
        int[] nums = {3, 2, 1, 0, 4};
        assertFalse(canJump(nums));
    }
}
