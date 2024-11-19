package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Hard
public class P0212_Word_Search_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
        char[][] board = {
            {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        assertEquals("[oath, eat]", solution.findWords(board, words).toString());
    }

    @Test
    void test63() {
        Solution solution = new Solution1();
        char[][] board = {
            {'m', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'},
            {'n', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'o', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'p', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'q', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'r', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'s', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'t', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'u', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'v', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'w', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'x', 'y', 'z', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}
        };
        String[] words = {
            "aaaaaaaaaa", "aaaaaaaaab", "aaaaaaaaac", "aaaaaaaaad", "aaaaaaaaae",
        };
        System.out.println(solution.findWords(board, words));
    }

    interface Solution {
        public List<String> findWords(char[][] board, String[] words);
    }

    // TODO Time Limit Exceeded
    class Solution1 implements Solution {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public List<String> findWords(char[][] board, String[] words) {
            return Arrays.stream(words).filter(w -> findWord(board, w)).toList();
        }

        boolean findWord(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, i, j, visited, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
            if (!isValid(board, i, j) || visited[i][j] || word.charAt(index) != board[i][j]) {
                return false;
            }
            index++;
            if (word.length() == index) {
                return true;
            }
            visited[i][j] = true;

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                boolean find = dfs(board, x, y, visited, word, index);
                if (find) {
                    return true;
                }
            }
            visited[i][j] = false;
            return false;
        }

        boolean isValid(char[][] board, int i, int j) {
            return 0 <= i && i < board.length && 0 <= j & j < board[0].length;
        }
    }
}
