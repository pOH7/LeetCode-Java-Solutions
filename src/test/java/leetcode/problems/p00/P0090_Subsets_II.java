package leetcode.problems.p00;

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
public class P0090_Subsets_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {0};
        System.out.println(solution.subsetsWithDup(nums));
    }

    interface Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), results);
            return results;
        }

        void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> results) {
            results.add(new ArrayList<>(temp));
            for (int i = index; i < nums.length; i++) {
                // skip same element
                if (i != index && nums[i - 1] == nums[i]) {
                    continue;
                }
                // only consider adding once
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, results);
                // or not adding
                temp.remove(temp.size() - 1);
            }
        }
    }
}
