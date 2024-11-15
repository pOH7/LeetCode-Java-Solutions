package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Medium
public class P0046_Permutations {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {1, 2, 3};
        assertEquals(
                "[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]",
                solution.permute(nums).toString().replace(" ", ""));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {0, 1};
        assertEquals("[[0,1],[1,0]]", solution.permute(nums).toString().replace(" ", ""));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int[] nums = {1};
        assertEquals("[[1]]", solution.permute(nums).toString().replace(" ", ""));
    }

    interface Solution {
        public List<List<Integer>> permute(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> permute(int[] nums) {
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
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                temp.add(nums[i]);
                backtrack(nums, temp, used, results);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    class Solution2 implements Solution {

        @Override
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            permute(
                    Arrays.stream(nums).boxed().collect(Collectors.toList()),
                    new ArrayList<>(),
                    result);
            return result;
        }

        void permute(List<Integer> nums, List<Integer> temp, List<List<Integer>> result) {
            if (nums.size() == 0) {
                result.add(new ArrayList<>(temp));
            } else {
                for (int i = 0, len = nums.size(); i < len; i++) {
                    temp.add(nums.remove(i));
                    permute(nums, temp, result);
                    nums.add(i, temp.remove(temp.size() - 1));
                }
            }
        }
    }
}
