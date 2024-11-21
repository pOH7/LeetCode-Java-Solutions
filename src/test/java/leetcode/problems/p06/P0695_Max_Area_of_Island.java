package leetcode.problems.p06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
@Medium
public class P0695_Max_Area_of_Island {
    @Test
    void test1() {
        Solution solution = new Solution2();
        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        assertEquals(6, solution.maxAreaOfIsland(grid));
    }

    interface Solution {
        public int maxAreaOfIsland(int[][] grid);
    }

    // 2 ms Beats 70.21%
    class Solution1 implements Solution {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        @Override
        public int maxAreaOfIsland(int[][] grid) {
            int maxSize = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    maxSize = Math.max(maxSize, dfsMatrix(grid, i, j));
                }
            }
            return maxSize;
        }

        int dfsMatrix(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                return 0;
            }
            if (grid[i][j] == 0) {
                return 0;
            }
            grid[i][j] = 0;
            int areaSize = 1;
            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];
                areaSize += dfsMatrix(grid, x, y);
            }
            return areaSize;
        }
    }

    // 3 ms Beats 29.40%
    class Solution2 implements Solution {
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        @Override
        public int maxAreaOfIsland(int[][] grid) {
            int maxSize = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    maxSize = Math.max(maxSize, bfsMatrix(grid, i, j));
                }
            }
            return maxSize;
        }

        int bfsMatrix(int[][] grid, int i, int j) {
            if (grid[i][j] == 0) {
                return 0;
            }
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] {i, j});
            grid[i][j] = 0;
            int areaSize = 0;

            while (!q.isEmpty()) {
                int[] node = q.poll();
                areaSize++;
                for (int[] direction : directions) {
                    int x = node[0] + direction[0];
                    int y = node[1] + direction[1];
                    if (x >= 0
                            && x < grid.length
                            && y >= 0
                            && y < grid[0].length
                            && grid[x][y] == 1) {
                        q.offer(new int[] {x, y});
                        grid[x][y] = 0;
                    }
                }
            }
            return areaSize;
        }
    }
}
