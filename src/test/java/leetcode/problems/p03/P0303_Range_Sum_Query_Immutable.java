package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0303_Range_Sum_Query_Immutable {
    @Test
    void test() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        assertEquals(1, numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        assertEquals(-1, numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        assertEquals(-3, numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }

    class NumArray {

        final int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sums[i] = nums[i];
                } else {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sums[right];
            } else {
                return sums[right] - sums[left - 1];
            }
        }
    }
}
