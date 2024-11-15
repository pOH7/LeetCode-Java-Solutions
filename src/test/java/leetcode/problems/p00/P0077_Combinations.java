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
public class P0077_Combinations {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int n = 4, k = 2;
        System.out.println(solution.combine(n, k));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int n = 1, k = 1;
        System.out.println(solution.combine(n, k));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int n = 2, k = 3;
        System.out.println(solution.combine(n, k));
    }

    interface Solution {
        public List<List<Integer>> combine(int n, int k);
    }

    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> results = new ArrayList<>();
            if (n < k) {
                return results;
            }
            backtrack(n, k, new ArrayList<>(), results);
            return results;
        }

        void backtrack(int n, int k, List<Integer> temp, List<List<Integer>> results) {
            if (k == temp.size()) {
                results.add(new ArrayList<>(temp));
                return;
            }
            for (int i = n; i > 0; i--) {
                temp.add(i);
                backtrack(i - 1, k, temp, results);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
