package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 11/15/24
 */
public class P0079_Word_Search {
    @Test
    void test1() {
        Solution solution = new Solution1();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        assertTrue(solution.exist(board, word));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        assertTrue(solution.exist(board, word));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        assertFalse(solution.exist(board, word));
    }

    interface Solution {
        public boolean exist(char[][] board, String word);
    }

    class Solution1 implements Solution {

        @Override
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean found =
                            backtrack(
                                    board,
                                    word,
                                    new boolean[board.length][board[0].length],
                                    i,
                                    j,
                                    0);
                    if (found) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(
                char[][] board, String word, boolean[][] visited, int i, int j, int index) {
            if (index == word.length()) {
                return true;
            }
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
                return false;
            }

            if (visited[i][j] || word.charAt(index) != board[i][j]) {
                return false;
            }

            visited[i][j] = true;
            if (backtrack(board, word, visited, i + 1, j, index + 1)
                    || backtrack(board, word, visited, i, j + 1, index + 1)
                    || backtrack(board, word, visited, i - 1, j, index + 1)
                    || backtrack(board, word, visited, i, j - 1, index + 1)) {
                return true;
            }

            visited[i][j] = false;
            return false;
        }
    }
}
