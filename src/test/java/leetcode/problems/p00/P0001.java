package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Two Sum
 *
 * @link https://leetcode.com/problems/two-sum/
 * @author zhanglei
 * @date 2021/5/17
 */
class P0001 {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (temps.containsKey(nums[i])) {
                return new int[] {temps.get(nums[i]), i};
            }
            temps.put(target - nums[i], i);
        }
        return null;
    }

    /*
    // not good
    int[] twoSum(int[] nums, int target) {
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (temps[j] == nums[i]) {
                    return new int[] {j, i};
                }
            }
            temps[i] = target - nums[i];
        }
        return null;
    }
    */

    @Test
    void test1() {
        assertEquals("[0, 1]", Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
    }

    @Test
    void test2() {
        assertEquals("[1, 2]", Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
    }

    @Test
    void test3() {
        assertEquals("[0, 1]", Arrays.toString(twoSum(new int[] {3, 3}, 6)));
    }
}
