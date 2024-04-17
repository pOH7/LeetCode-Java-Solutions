package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 376. Wiggle Subsequence
 *
 * @link https://leetcode.com/problems/wiggle-subsequence/
 * @author zhanglei
 * @date 2022/4/25
 */
class P0376 {
    // Dynamic Programming
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    @Test
    void test1() {
        int[] nums = {1, 7, 4, 9, 2, 5};
        assertEquals(6, wiggleMaxLength(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        assertEquals(7, wiggleMaxLength(nums));
    }

    @Test
    void test3() {
        int[] nums = {0, 0, 0};
        assertEquals(1, wiggleMaxLength(nums));
    }
}
