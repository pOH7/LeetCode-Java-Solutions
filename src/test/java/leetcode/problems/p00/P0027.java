package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 27. Remove Element
 *
 * @link https://leetcode.com/problems/remove-element/
 * @author zhanglei
 * @date 2022/2/22
 */
class P0027 {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j <= nums.length - 1) {
            if (nums[j] == val) {
                j++;
            } else {
                nums[i++] = nums[j++];
            }
        }
        return i;
    }

    /*
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[--j];
            } else {
                i++;
            }
        }
        return i;
    }
     */

    /*
    // not good
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                exchange(nums, i, --j);
            } else {
                i++;
            }
        }
        return i;
    }

    static void exchange(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
     */

    @Test
    void test1() {
        int[] nums = {3, 2, 2, 3};
        test(nums, 3, 2);
    }

    @Test
    void test2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        test(nums, 2, 5);
    }

    private void test(int[] nums, int val, int result) {
        assertEquals(result, removeElement(nums, val));
        assertTrue(Arrays.stream(nums).limit(result).allMatch(i -> i != val));
    }
}
