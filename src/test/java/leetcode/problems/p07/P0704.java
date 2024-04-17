package leetcode.problems.p07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

/**
 * 704. Binary Search
 *
 * @link https://leetcode.com/problems/binary-search/
 * @author zhanglei
 * @date 2022/2/22
 */
@Slf4j
class P0704 {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }

    /*
    // not good
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            log.info("low = {}, high = {}, mid = {}", low, high, mid);
            if (target == nums[mid]) {
                return mid;
            } else if (low == high) {
                return -1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
    */

    @Test
    void test1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(4, search(nums, 9));
    }

    @Test
    void test2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        assertEquals(-1, search(nums, 2));
    }
}
