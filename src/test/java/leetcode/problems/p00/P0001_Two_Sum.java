package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @link https://leetcode.com/problems/two-sum/
 * @author zhanglei
 * @date 2021/5/17
 */
class P0001_Two_Sum {

    @Test
    void test1() {
        Solution solution = new Solution1();
        assertEquals("[0, 1]", Arrays.toString(solution.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        assertEquals("[1, 2]", Arrays.toString(solution.twoSum(new int[] {3, 2, 4}, 6)));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        assertEquals("[0, 1]", Arrays.toString(solution.twoSum(new int[] {3, 3}, 6)));
    }

    interface Solution {
        public int[] twoSum(int[] nums, int target);
    }

    class Solution1 implements Solution {

        @Override
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> temps = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (temps.containsKey(nums[i])) {
                    return new int[] {temps.get(nums[i]), i};
                }
                temps.put(target - nums[i], i);
            }
            return null;
        }
    }
}
