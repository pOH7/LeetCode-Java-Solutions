package leetcode.problems.p00;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/16/24
 */
@Medium
public class P0022_Generate_Parentheses {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int n = 3;
        System.out.println(solution.generateParenthesis(n));
    }

    interface Solution {
        public List<String> generateParenthesis(int n);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtracking(n, 0, 0, new StringBuilder(), ans);
            return ans;
        }

        void backtracking(int n, int idxOpen, int idxClosed, StringBuilder ds, List<String> ans) {
            if (idxOpen == n && idxClosed == n) {
                ans.add(ds.toString());
                return;
            }
            if (idxOpen < n) {
                ds.append("(");
                backtracking(n, idxOpen + 1, idxClosed, ds, ans);
                ds.deleteCharAt(ds.length() - 1);
            }
            if (idxClosed < idxOpen) {
                ds.append(")");
                backtracking(n, idxOpen, idxClosed + 1, ds, ans);
                ds.deleteCharAt(ds.length() - 1);
            }
        }
    }
}
