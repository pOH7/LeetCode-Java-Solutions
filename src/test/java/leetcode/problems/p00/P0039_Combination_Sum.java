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
public class P0039_Combination_Sum {

    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(solution.combinationSum(candidates, target));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int[] candidates = {2};
        int target = 1;
        System.out.println(solution.combinationSum(candidates, target));
    }

    interface Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target);
    }

    // 2 ms Beats 84.67%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] < 0) {
                    break;
                }
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, temp, results);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
