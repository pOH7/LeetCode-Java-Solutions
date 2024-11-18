package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglei
 * @version 11/18/24
 */
@Medium
public class P0200_Number_of_Islands {
    @Test
    void test1() {
        Solution solution = new Solution1();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    void test39() {
        Solution solution = new Solution1();
        char[][] grid = {{'1', '0', '1', '1', '0', '1', '1'}};
        assertEquals(3, solution.numIslands(grid));
    }

    interface Solution {
        public int numIslands(char[][] grid);
    }

    // 7 ms Beats 19.25%
    class Solution1 implements Solution {
        static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        @Override
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<Integer> q = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        bfs(grid, m, n, i, j, q, visited);
                        count++;
                    }
                }
            }
            return count;
        }

        void bfs(char[][] grid, int m, int n, int i, int j, Queue<Integer> q, boolean[][] visited) {
            visited[i][j] = true;
            q.clear();
            q.offer(i * n + j);
            while (!q.isEmpty()) {
                Integer node = q.poll();
                for (int[] direction : directions) {
                    int x = node / n + direction[0];
                    int y = node % n + direction[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !visited[x][y] && grid[x][y] == '1') {
                        q.offer(x * n + y);
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
