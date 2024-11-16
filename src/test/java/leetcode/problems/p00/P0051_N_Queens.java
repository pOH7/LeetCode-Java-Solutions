package leetcode.problems.p00;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/16/24
 */
@Hard
public class P0051_N_Queens {
    @Test
    void test1() {
        Solution solution = new Solution2();
        int n = 4;
        System.out.println(solution.solveNQueens(n));
    }

    interface Solution {
        public List<List<String>> solveNQueens(int n);
    }

    // 2 ms Beats 87.43%
    class Solution1 implements Solution {
        @Override
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            List<List<String>> ans = new ArrayList<>();
            backtracking(n, board, 0, ans);
            return ans;
        }

        void backtracking(int n, char[][] board, int idx, List<List<String>> ans) {
            if (n == 0) {
                List<String> rows = new ArrayList<>();
                for (char[] row : board) {
                    rows.add(new String(row));
                }
                ans.add(rows);
            }

            for (int j = 0; j < board.length; j++) {
                if (isSafe(board, idx, j)) {
                    board[idx][j] = 'Q';
                    backtracking(n - 1, board, idx + 1, ans);
                    board[idx][j] = '.';
                }
            }
        }

        boolean isSafe(char[][] board, int idx, int idy) {
            // check upper
            for (int i = 0; i < idx; i++) {
                if (board[i][idy] == 'Q') {
                    return false;
                }
            }
            // check upper-left
            for (int i = idx - 1, j = idy - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            // check upper-right
            for (int i = idx - 1, j = idy + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

    // 1 ms Beats 99.79%
    class Solution2 implements Solution {
        @Override
        public List<List<String>> solveNQueens(int n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            List<List<String>> ans = new ArrayList<>();
            backtracking(
                    n,
                    board,
                    0,
                    new boolean[n],
                    new boolean[2 * n - 1],
                    new boolean[2 * n - 1],
                    ans);
            return ans;
        }

        void backtracking(
                int n,
                char[][] board,
                int idx,
                boolean[] cols,
                boolean[] ld,
                boolean[] rd,
                List<List<String>> ans) {
            if (n == 0) {
                List<String> rows = new ArrayList<>();
                for (char[] row : board) {
                    rows.add(new String(row));
                }
                ans.add(rows);
            }

            for (int j = 0; j < board.length; j++) {
                int ild = idx + j;
                int ird = idx - j + board.length - 1;
                if (cols[j] || ld[ild] || rd[ird]) {
                    continue;
                }
                cols[j] = true;
                ld[ild] = true;
                rd[ird] = true;
                board[idx][j] = 'Q';
                backtracking(n - 1, board, idx + 1, cols, ld, rd, ans);
                cols[j] = false;
                ld[ild] = false;
                rd[ird] = false;
                board[idx][j] = '.';
            }
        }
    }
}
