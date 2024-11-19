package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class P0207_Course_Schedule {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        assertTrue(solution.canFinish(numCourses, prerequisites));
    }

    interface Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites);
    }

    // 7 ms Beats 52.09%
    class Solution1 implements Solution {
        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>();
            int[] inDegree = new int[numCourses];

            for (int i = 0; i < inDegree.length; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[0];
                int to = prerequisite[1];
                adjList.get(from).add(to);
                inDegree[to]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
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

            return topologicalOrder.size() == numCourses;
        }
    }
}
