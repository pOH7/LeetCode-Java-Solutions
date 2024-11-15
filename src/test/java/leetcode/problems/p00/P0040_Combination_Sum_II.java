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
public class P0040_Combination_Sum_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(solution.combinationSum2(candidates, target));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(solution.combinationSum2(candidates, target));
    }

    interface Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target);
    }

    // 2 ms Beats 99.81%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, 0, new ArrayList<>(), results);
            return results;
        }

        void backtrack(
                int[] candidates,
                int target,
                int index,
                List<Integer> temp,
                List<List<Integer>> results) {
            if (target == 0) {
                results.add(new ArrayList<>(temp));
                return;
            }
            Integer prev = null;
            for (int i = index; i < candidates.length; i++) {
                if (i != index && prev != null && prev == candidates[i]) {
                    continue;
                }
                if (target - candidates[i] < 0) {
                    break;
                }
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, temp, results);
                prev = temp.remove(temp.size() - 1);
            }
        }
    }
}
