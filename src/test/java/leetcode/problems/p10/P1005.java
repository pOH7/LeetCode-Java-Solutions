package leetcode.problems.p10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 1005. Maximize Sum Of Array After K Negations
 *
 * @link https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 * @author zhanglei
 * @date 2022/4/27
 */
class P1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (k != 0) {
            if (nums[i] == 0) {
                break;
            } else if (nums[i] > 0) {
                if (k % 2 != 0) {
                    if (i > 0 && Math.abs(nums[i - 1]) < nums[i]) {
                        nums[i - 1] = -nums[i - 1];
                    } else {
                        nums[i] = -nums[i];
                    }
                }
                break;
            } else {
                nums[i] = -nums[i];
                k--;
                if (i + 1 < nums.length) {
                    i++;
                }
            }
        }
        return Arrays.stream(nums).sum();
    }

    @Test
    void test1() {
        int[] nums = {4, 2, 3};
        Assertions.assertEquals(5, largestSumAfterKNegations(nums, 1));
    }

    @Test
    void test2() {
        int[] nums = {3, -1, 0, 2};
        Assertions.assertEquals(6, largestSumAfterKNegations(nums, 3));
    }

    @Test
    void test3() {
        int[] nums = {2, -3, -1, 5, -4};
        Assertions.assertEquals(13, largestSumAfterKNegations(nums, 2));
    }
}
