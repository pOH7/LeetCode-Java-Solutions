package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.com/problems/search-insert-position/
 * @author zhanglei
 * @date 2021/12/1
 */
public class P0035 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }

    @Test
    void test() {
        int[] nums = {1, 3, 5, 6};
        assertEquals(2, searchInsert(nums, 5));
    }
}
