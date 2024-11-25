package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhanglei
 * @version 2024/11/25
 */
@Medium
public class P0378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        assertEquals(13, solution.kthSmallest(matrix, k));
    }

    interface Solution {
        public int kthSmallest(int[][] matrix, int k);
    }

    // 21 ms Beats 21.05%
    class Solution1 implements Solution {

        int[][] directions = {{1, 0}, {0, 1}};

        @Override
        public int kthSmallest(int[][] matrix, int k) {
            Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            q.offer(new int[] {0, 0, matrix[0][0]});
            while (k-- > 0) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];
                if (k == 0) {
                    return node[2];
                }
                matrix[i][j] = Integer.MAX_VALUE;
                for (int[] direction : directions) {
                    int x = i + direction[0];
                    int y = j + direction[1];
                    if (x >= 0
                            && x < matrix.length
                            && y >= 0
                            && y < matrix[0].length
                            && matrix[x][y] != Integer.MAX_VALUE) {
                        q.offer(new int[] {x, y, matrix[x][y]});
                        matrix[x][y] = Integer.MAX_VALUE;
                    }
                }
            }
            return 0;
        }
    }
}
