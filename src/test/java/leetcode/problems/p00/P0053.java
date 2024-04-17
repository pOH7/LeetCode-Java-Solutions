package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 53. Maximum Subarray
 *
 * @link https://leetcode.com/problems/maximum-subarray/
 * @reference https://en.wikipedia.org/wiki/Maximum_subarray_problem
 * @reference
 *     https://leetcode.com/problems/maximum-subarray/discuss/20452/C%2B%2B-DP-and-Divide-and-Conquer
 * @author zhanglei
 * @date 2022/4/26
 */
class P0053 {
    // Dynamic Programming
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }

    @Test
    void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, maxSubArray(nums));
    }

    @Test
    void test2() {
        int[] nums = {1};
        assertEquals(1, maxSubArray(nums));
    }

    @Test
    void test3() {
        int[] nums = {5, 4, -1, 7, 8};
        assertEquals(23, maxSubArray(nums));
    }

    @Test
    void test4() {
        int[] nums = {-1};
        assertEquals(-1, maxSubArray(nums));
    }

    @Test
    void test5() {
        int[] nums = {8, -19, 5, -4, 20};
        assertEquals(21, maxSubArray(nums));
    }
}
