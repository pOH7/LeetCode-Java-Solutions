package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @link https://leetcode.com/problems/valid-sudoku/
 * @link https://leetcode.com/problems/valid-sudoku/discuss/15472/Short+Simple-Java-using-Strings
 * @author zhanglei
 * @date 2021/12/1
 */
public class P0036 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rule1 = new HashSet<>(9);
        Map<Integer, Set<Character>> rule2 = new HashMap<>(9);
        for (int i = 0; i < 9; i++) {
            rule2.put(i, new HashSet<>(9));
        }
        Map<Integer, Set<Character>> rule3 = new HashMap<>(3);
        for (int i = 0; i < 3; i++) {
            rule3.put(i, new HashSet<>(3));
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char aChar = board[i][j];
                if (aChar != '.') {
                    if (!rule1.add(aChar)) {
                        return false;
                    }
                    if (!rule2.get(j).add(aChar)) {
                        return false;
                    }
                    if (!rule3.get(j / 3).add(aChar)) {
                        return false;
                    }
                }
            }
            rule1.clear();
            if (i % 3 == 2) {
                rule3.values().forEach(Set::clear);
            }
        }
        return true;
    }

    @Test
    void test() {
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
        assertTrue(isValidSudoku(board));
    }

    @Test
    void test2() {
        char[][] board = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertFalse(isValidSudoku(board));
    }
}
