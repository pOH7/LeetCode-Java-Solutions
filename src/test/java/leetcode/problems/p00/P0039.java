package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 39. Combination Sum
 *
 * @link https://leetcode.com/problems/combination-sum/
 * @author zhanglei
 * @date 2022/4/12
 */
class P0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    void combinationSum(
            int[] candidates,
            int target,
            int index,
            List<Integer> temp,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else if (target > 0) {
            while (index < candidates.length) {
                int i = candidates[index];
                temp.add(i);
                combinationSum(candidates, target - i, index++, temp, result);
                temp.remove(Integer.valueOf(i));
            }
        }
    }

    @Test
    void test1() {
        int[] candidates = {2, 3, 6, 7};
        assertEquals("[[2, 2, 3], [7]]", combinationSum(candidates, 7).toString());
    }

    @Test
    void test2() {
        int[] candidates = {2, 3, 5};
        assertEquals("[[2, 2, 2, 2], [2, 3, 3], [3, 5]]", combinationSum(candidates, 8).toString());
    }

    @Test
    void test3() {
        int[] candidates = {2};
        assertEquals("[]", combinationSum(candidates, 1).toString());
    }
}
