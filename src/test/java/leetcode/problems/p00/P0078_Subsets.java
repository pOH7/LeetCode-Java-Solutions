package leetcode.problems.p00;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Medium
public class P0078_Subsets {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {0};
        System.out.println(solution.subsets(nums));
    }

    interface Solution {
        public List<List<Integer>> subsets(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            backtrack(nums, 0, new ArrayList<>(), results);
            return results;
        }

        void backtrack(int[] nums, int index, List<Integer> temp, List<List<Integer>> results) {
            results.add(new ArrayList<>(temp));

            // not necessary, as i < nums.length
            //            if (index == nums.length) {
            //                return;
            //            }

            // for each element
            for (int i = index; i < nums.length; i++) {
                // we can choose to add it
                temp.add(nums[i]);
                backtrack(nums, i + 1, temp, results);
                // or not add it
                temp.remove(temp.size() - 1);
            }
        }
    }
}
