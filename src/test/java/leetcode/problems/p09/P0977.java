package leetcode.problems.p09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 *
 * @link https://leetcode.com/problems/squares-of-a-sorted-array/
 * @author zhanglei
 * @date 2022/2/22
 */
@Slf4j
class P0977 {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = nums.length - 1, neg = 0, pos = nums.length - 1; i >= 0; i--) {
            if (nums[neg] * nums[neg] < nums[pos] * nums[pos]) {
                result[i] = nums[pos] * nums[pos];
                pos--;
            } else {
                result[i] = nums[neg] * nums[neg];
                neg++;
            }
        }

        return result;
    }

    /*
    // not good
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int posStart = 0; // >=0
        while (posStart < nums.length) {
            if (nums[posStart] < 0) {
                posStart++;
            } else {
                break;
            }
        }
        log.info("posStart = {}", posStart);
        for (int i = 0, neg = posStart - 1, pos = posStart; i < nums.length; i++) {
            log.info("neg = {}, pos = {}", neg, pos);
            if (neg == -1) {
                result[i] = nums[pos] * nums[pos];
                pos++;
            } else if (pos == nums.length) {
                result[i] = nums[neg] * nums[neg];
                neg--;
            } else if ((-nums[neg]) > nums[pos]) {
                result[i] = nums[pos] * nums[pos];
                pos++;
            } else {
                result[i] = nums[neg] * nums[neg];
                neg--;
            }
        }

        return result;
    }
     */

    @Test
    void test1() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = {0, 1, 9, 16, 100};
        assertEquals(Arrays.toString(result), Arrays.toString(sortedSquares(nums)));
    }

    @Test
    void test2() {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] result = {4, 9, 9, 49, 121};
        assertEquals(Arrays.toString(result), Arrays.toString(sortedSquares(nums)));
    }
}
