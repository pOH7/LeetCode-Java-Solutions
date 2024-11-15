package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Medium
public class P0047_Permutations_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 1, 2};
        assertEquals("[[1, 1, 2], [1, 2, 1], [2, 1, 1]]", solution.permuteUnique(nums).toString());
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {1, 2, 3};
        assertEquals(
                "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]",
                solution.permuteUnique(nums).toString());
    }

    interface Solution {
        public List<List<Integer>> permuteUnique(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();
            backtrack(nums, new ArrayList<>(), new boolean[nums.length], results);
            return results;
        }

        void backtrack(
                int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> results) {
            if (temp.size() == nums.length) {
                results.add(new ArrayList<>(temp));
                return;
            }
            Integer prev = null;
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || prev != null && prev == nums[i]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, temp, used, results);
                used[i] = false;
                prev = temp.remove(temp.size() - 1);
            }
        }
    }
}
