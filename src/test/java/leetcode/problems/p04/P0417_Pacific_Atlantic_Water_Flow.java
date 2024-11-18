package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei
 * @version 11/18/24
 */
@Medium
public class P0417_Pacific_Atlantic_Water_Flow {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[][] heights = {
            {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
        };
        assertEquals(
                "[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]",
                solution.pacificAtlantic(heights).toString().replace(" ", ""));
    }

    @Test
    void test50() {
        Solution solution = new Solution1();
        int[][] heights = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertEquals(
                "[[0,2],[1,0],[1,1],[1,2],[2,0],[2,1],[2,2]]",
                solution.pacificAtlantic(heights).toString().replace(" ", ""));
    }

    interface Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights);
    }

    // 9 ms Beats 43.48%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;

            // consider the Pacific Ocean
            boolean[][] canFlowToThePacificOceans = new boolean[m][n];
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                canFlowToThePacificOceans[i][0] = true;
                q.offerLast(new int[] {i, 0});
            }
            for (int j = 0; j < n; j++) {
                canFlowToThePacificOceans[0][j] = true;
                q.offerLast(new int[] {0, j});
            }
            bfs(heights, m, n, q, canFlowToThePacificOceans);

            // consider the Atlantic Ocean
            boolean[][] canFlowToTheAtlanticOceans = new boolean[m][n];
            // LinkedList<int[]> q = new LinkedList<>();
            q.clear();
            for (int i = 0; i < m; i++) {
                canFlowToTheAtlanticOceans[i][n - 1] = true;
                q.offerLast(new int[] {i, n - 1});
            }
            for (int j = 0; j < n; j++) {
                canFlowToTheAtlanticOceans[m - 1][j] = true;
                q.offerLast(new int[] {m - 1, j});
            }
            bfs(heights, m, n, q, canFlowToTheAtlanticOceans);

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canFlowToThePacificOceans[i][j] && canFlowToTheAtlanticOceans[i][j]) {
                        ans.add(List.of(i, j));
                    }
                }
            }
            return ans;
        }

        private void bfs(
                int[][] heights, int m, int n, LinkedList<int[]> q, boolean[][] canFlowToOceans) {
            while (!q.isEmpty()) {
                int[] grid = q.pollFirst();
                // east
                if (grid[1] + 1 < n && heights[grid[0]][grid[1] + 1] >= heights[grid[0]][grid[1]]) {
                    if (!canFlowToOceans[grid[0]][grid[1] + 1]) {
                        canFlowToOceans[grid[0]][grid[1] + 1] = true;
                        q.offerLast(new int[] {grid[0], grid[1] + 1});
                    }
                }
                // west
                if (grid[1] - 1 >= 0
                        && heights[grid[0]][grid[1] - 1] >= heights[grid[0]][grid[1]]) {
                    if (!canFlowToOceans[grid[0]][grid[1] - 1]) {
                        canFlowToOceans[grid[0]][grid[1] - 1] = true;
                        q.offerLast(new int[] {grid[0], grid[1] - 1});
                    }
                }
                // north
                if (grid[0] - 1 >= 0
                        && heights[grid[0] - 1][grid[1]] >= heights[grid[0]][grid[1]]) {
                    if (!canFlowToOceans[grid[0] - 1][grid[1]]) {
                        canFlowToOceans[grid[0] - 1][grid[1]] = true;
                        q.offerLast(new int[] {grid[0] - 1, grid[1]});
                    }
                }
                // south
                if (grid[0] + 1 < m && heights[grid[0] + 1][grid[1]] >= heights[grid[0]][grid[1]]) {
                    if (!canFlowToOceans[grid[0] + 1][grid[1]]) {
                        canFlowToOceans[grid[0] + 1][grid[1]] = true;
                        q.offerLast(new int[] {grid[0] + 1, grid[1]});
                    }
                }
            }
        }
    }

    // 11 ms Beats 33.70%
    class Solution2 implements Solution {
        static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        @Override
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;

            // consider the Pacific Ocean
            boolean[][] canFlowToThePacificOceans = new boolean[m][n];
            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                canFlowToThePacificOceans[i][0] = true;
                q.offerLast(i * n);
            }
            for (int j = 0; j < n; j++) {
                canFlowToThePacificOceans[0][j] = true;
                q.offerLast(j);
            }
            bfs(heights, m, n, q, canFlowToThePacificOceans);

            // consider the Atlantic Ocean
            boolean[][] canFlowToTheAtlanticOceans = new boolean[m][n];
            // LinkedList<int[]> q = new LinkedList<>();
            q.clear();
            for (int i = 0; i < m; i++) {
                canFlowToTheAtlanticOceans[i][n - 1] = true;
                q.offerLast(i * n + n - 1);
            }
            for (int j = 0; j < n; j++) {
                canFlowToTheAtlanticOceans[m - 1][j] = true;
                q.offerLast((m - 1) * n + j);
            }
            bfs(heights, m, n, q, canFlowToTheAtlanticOceans);

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (canFlowToThePacificOceans[i][j] && canFlowToTheAtlanticOceans[i][j]) {
                        ans.add(List.of(i, j));
                    }
                }
            }
            return ans;
        }

        private void bfs(
                int[][] heights, int m, int n, LinkedList<Integer> q, boolean[][] visited) {
            while (!q.isEmpty()) {
                Integer code = q.pollFirst();
                for (int[] direction : directions) {
                    int x = code / n + direction[0];
                    int y = code % n + direction[1];
                    if (0 <= x
                            && x < m
                            && 0 <= y
                            && y < n
                            && !visited[x][y]
                            && heights[x][y] >= heights[code / n][code % n]) {
                        q.offer(x * n + y);
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
