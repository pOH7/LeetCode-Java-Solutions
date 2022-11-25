package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 40. Combination Sum II
 *
 * @link https://leetcode.com/problems/combination-sum-ii/
 * @author zhanglei
 * @date 2022/4/12
 */
class P0040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    void combinationSum2(
            int[] candidates,
            int target,
            int index,
            List<Integer> temp,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else if (target > 0) {
            for (int cur = index; cur < candidates.length; cur++) {
                if (cur > index && candidates[cur] == candidates[cur - 1]) {
                    continue;
                }
                int i = candidates[cur];
                temp.add(i);
                combinationSum2(candidates, target - i, cur + 1, temp, result);
                temp.remove(Integer.valueOf(i));
            }
        }
    }

    @Test
    void test1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        assertEquals(
                "[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]",
                combinationSum2(candidates, 8).toString());
    }

    @Test
    void test2() {
        int[] candidates = {2, 5, 2, 1, 2};
        assertEquals("[[1, 2, 2], [5]]", combinationSum2(candidates, 5).toString());
    }
}
