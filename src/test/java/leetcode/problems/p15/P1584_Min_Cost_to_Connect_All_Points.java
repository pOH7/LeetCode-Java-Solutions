package leetcode.problems.p15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
@Medium
public class P1584_Min_Cost_to_Connect_All_Points {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        assertEquals(20, solution.minCostConnectPoints(points));
    }

    interface Solution {
        public int minCostConnectPoints(int[][] points);
    }

    // 73 ms Beats 83.67%
    class Solution1 implements Solution {
        @Override
        public int minCostConnectPoints(int[][] points) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            boolean[] visited = new boolean[points.length];
            minHeap.offer(new int[] {0, 0});
            int added = 0;
            int cost = 0;
            while (added < points.length) {
                int[] current = minHeap.poll();
                int index = current[0];
                if (visited[index]) {
                    continue;
                }
                cost += current[1];
                visited[index] = true;
                added++;
                for (int i = 0; i < points.length; i++) {
                    if (visited[i]) {
                        continue;
                    }
                    int minCost =
                            Math.abs(points[index][0] - points[i][0])
                                    + Math.abs(points[index][1] - points[i][1]);
                    minHeap.offer(new int[] {i, minCost});
                }
            }

            return cost;
        }
    }
}
