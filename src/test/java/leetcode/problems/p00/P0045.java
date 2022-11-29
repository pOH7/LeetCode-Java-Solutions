package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 45. Jump Game II
 *
 * @link https://leetcode.com/problems/jump-game-ii/
 * @author zhanglei
 * @date 2022/4/26
 */
class P0045 {

    // O(n)
    public int jump(int[] nums) {
        int step = 0;
        int currentStepEnd = 0;
        int nextStepCanReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextStepCanReach = Math.max(nextStepCanReach, nums[i] + i);
            if (i == currentStepEnd) { // i < nums.length - 1, so trigger another jump
                step++;
                currentStepEnd = nextStepCanReach;
            }
        }
        return step;
    }

    /*
    public int jump(int[] nums) {
        int end = nums.length - 1;
        int step = 0;
        for (int i = 0; i < end; i++) {
            if (nums[i] >= end - i) {
                end = i;
                i = -1;
                step++;
            }
        }
        return step;
    }
    */

    @Test
    void test1() {
        int[] nums = {2, 3, 1, 1, 4};
        assertEquals(2, jump(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 3, 0, 1, 4};
        assertEquals(2, jump(nums));
    }
}
