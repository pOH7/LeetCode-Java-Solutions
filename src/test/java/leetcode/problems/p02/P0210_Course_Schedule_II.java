package leetcode.problems.p02;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0210_Course_Schedule_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
    }

    interface Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites);
    }

    // 5 ms Beats 78.44%
    class Solution1 implements Solution {
        @Override
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>();
            int[] inDegree = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[1];
                int to = prerequisite[0];
                adjList.get(from).add(to);
                inDegree[to]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }

            List<Integer> topologicalOrder = new ArrayList<>();
            while (!q.isEmpty()) {
                int node = q.poll();
                topologicalOrder.add(node);
                for (Integer neighbor : adjList.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        q.offer(neighbor);
                    }
                }
            }
            if (topologicalOrder.size() != numCourses) {
                return new int[0];
            }
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = topologicalOrder.get(i);
            }
            return ans;
        }
    }
}
