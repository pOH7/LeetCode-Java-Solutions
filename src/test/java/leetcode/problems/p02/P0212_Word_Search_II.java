package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void test64() {
        Solution solution = new Solution1();
        char[][] board = {
            {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };
        String[] words = {
            "oath", "pea", "eat", "rain", "oathi", "oathk", "oathf", "oate", "oathii", "oathfi",
            "oathfii"
        };
        System.out.println(solution.findWords(board, words));
    }

    interface Solution {
        public List<String> findWords(char[][] board, String[] words);
    }

    // 309 ms Beats 45.34%
    class Solution1 implements Solution {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public List<String> findWords(char[][] board, String[] words) {
            TireNode root = new TireNode();
            for (String word : words) {
                TireNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TireNode();
                    }
                    node = node.children[index];
                }
                node.word = word;
            }
            List<String> ans = new ArrayList<>();
            findWords(board, root, ans);
            return ans;
        }

        void findWords(char[][] board, TireNode root, List<String> ans) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    dfs(board, i, j, visited, root, ans);
                }
            }
        }

        void dfs(
                char[][] board,
                int i,
                int j,
                boolean[][] visited,
                TireNode root,
                List<String> ans) {
            if (!isValid(board, i, j)
                    || visited[i][j]
                    || root.children[board[i][j] - 'a'] == null) {
                return;
            }
            root = root.children[board[i][j] - 'a'];
            if (root.word != null) {
                ans.add(root.word);
                root.word = null;
            }
            visited[i][j] = true;

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                dfs(board, x, y, visited, root, ans);
            }
            visited[i][j] = false;
        }

        class TireNode {
            TireNode[] children = new TireNode[26];
            String word;
        }

        boolean isValid(char[][] board, int i, int j) {
            return 0 <= i && i < board.length && 0 <= j & j < board[0].length;
        }
    }
}
