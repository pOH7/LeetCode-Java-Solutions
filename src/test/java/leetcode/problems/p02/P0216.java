package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * @link https://leetcode.com/problems/combination-sum-iii/
 * @author zhanglei
 * @date 2022/4/11
 */
class P0216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(k, n, 1, 9, new ArrayList<>(k), result);
        return result;
    }

    void combinationSum3(
            int k, int n, int min, int max, List<Integer> temp, List<List<Integer>> result) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = min; i <= max && k > 0 && n > 0; i++) {
                temp.add(i);
                combinationSum3(k - 1, n - i, i + 1, max, temp, result);
                temp.remove(Integer.valueOf(i));
            }
        }
    }

    @Test
    void test1() {
        assertEquals("[[1, 2, 4]]", combinationSum3(3, 7).toString());
    }

    @Test
    void test2() {
        assertEquals(
                "[[1, 2, 6], [1, 3, 5], [2, 3, 4]]", combinationSum3(3, 9).toString());
    }

    @Test
    void test3() {
        assertEquals("[]", combinationSum3(4, 1).toString());
    }
}
