package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author zhanglei
 * @version 2021/11/24
 * @link https://leetcode.com/problems/contains-duplicate-ii/
 */
public class P0219 {

    // sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>(k);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(num)) {
                return true;
            }
        }
        return false;
    }

    //    public boolean containsNearbyDuplicate(int[] nums, int k) {
    //        for (int i = 0, numsLength = nums.length; i < numsLength - 1; i++) {
    //            int num = nums[i];
    //            for (int j = i + 1; j <= i + k && j < numsLength; j++) {
    //                if (num == nums[j]) {
    //                    return true;
    //                }
    //            }
    //        }
    //        return false;
    //    }

    @Test
    void test() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(containsNearbyDuplicate(nums, 3));
    }

    @Test
    void test2() {
        int[] nums = {1, 0, 1, 1};
        assertTrue(containsNearbyDuplicate(nums, 1));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3, 1, 2, 3};
        assertFalse(containsNearbyDuplicate(nums, 2));
    }
}
