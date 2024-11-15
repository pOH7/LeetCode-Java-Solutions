package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Medium
public class P0216_Combination_Sum_III {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int k = 3, n = 7;
        assertEquals("[[1, 2, 4]]", solution.combinationSum3(k, n).toString());
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int k = 3, n = 9;
        assertEquals(
                "[[1, 2, 6], [1, 3, 5], [2, 3, 4]]", solution.combinationSum3(k, n).toString());
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int k = 4, n = 1;
        assertEquals("[]", solution.combinationSum3(k, n).toString());
    }

    interface Solution {
        public List<List<Integer>> combinationSum3(int k, int n);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            backtracking(k, n, 1, new ArrayList<>(), ans);
            return ans;
        }

        void backtracking(int k, int n, int idx, List<Integer> ds, List<List<Integer>> ans) {
            if (k == 0 && n == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }
            for (int i = idx; i <= 9; i++) {
                if (k < 0 || n - i * k < 0) {
                    break;
                }
                ds.add(i);
                backtracking(k - 1, n - i, i + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
    }
}
