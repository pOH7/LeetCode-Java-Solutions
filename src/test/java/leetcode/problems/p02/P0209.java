package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 209. Minimum Size Subarray Sum
 *
 * @link https://leetcode.com/problems/minimum-size-subarray-sum/
 * @author zhanglei
 * @date 2022/2/23
 */
class P0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int subArrayLen = nums.length + 1;
        int sum = 0;
        for (int j = 0; j <= nums.length - 1; j++) {
            if (j - i + 1 >= subArrayLen) {
                sum -= nums[i++];
            }
            sum += nums[j];
            while (sum >= target) {
                subArrayLen = j - i + 1;
                sum -= nums[i++];
            }
        }
        return subArrayLen > nums.length ? 0 : subArrayLen;
    }

    @Test
    void test1() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        assertEquals(2, minSubArrayLen(7, nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 4, 4};
        assertEquals(1, minSubArrayLen(4, nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        assertEquals(0, minSubArrayLen(11, nums));
    }
}
