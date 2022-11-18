package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 37. Sudoku Solver
 *
 * @link https://leetcode.com/problems/sudoku-solver/
 * @author zhanglei
 * @date 2022/4/24
 */
class P0037 {
    public void solveSudoku(char[][] board) {
        char[][] result = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                result[i][j] = '.';
            }
        }
        solveSudoku(board, 0, result);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = result[i][j];
                }
            }
        }
    }

    boolean solveSudoku(char[][] board, int n, char[][] result) {
        if (n / board.length >= board.length) {
            return true;
        }
        if (board[n / board.length][n % board.length] != '.') {
            if (solveSudoku(board, n + 1, result)) {
                return true;
            }
        }

        for (char c = '1'; c <= '9'; c++) {
            if (!valid(board, result, n / board.length, n % board.length, c)) {
                continue;
            }
            result[n / board.length][n % board.length] = c;
            if (solveSudoku(board, n + 1, result)) {
                return true;
            }
            result[n / board.length][n % board.length] = '.';
        }
        return false;
    }

    boolean valid(char[][] board, char[][] result, int x, int y, char c) {
        boolean valid = true;
        if (board[x][y] != '.') {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (i != x && (board[i][y] == c || result[i][y] == c)
                    || i != y && (board[x][i] == c || result[x][i] == c)) {
                valid = false;
                break;
            }
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (i != x && j != y && (board[i][j] == c || result[i][j] == c)) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }

    @Test
    void test1() {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] result = {
            {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        solveSudoku(board);
        assertArrayEquals(result, board);
    }
}
