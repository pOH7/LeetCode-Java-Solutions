package leetcode.problems.p03;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0310_Minimum_Height_Trees {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(solution.findMinHeightTrees(n, edges));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(solution.findMinHeightTrees(n, edges));
    }

    interface Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges);
    }

    // 30 ms Beats 43.94%
    class Solution1 implements Solution {
        @Override
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
                return List.of(0);
            }
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            LinkedList<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (adjList.get(i).size() == 1) {
                    q.offer(i);
                }
            }

            int remains = n;
            while (remains > 2) {
                for (int i = q.size(); i > 0; i--) {
                    int node = q.poll();
                    remains--;
                    for (int neighbor : adjList.get(node)) {
                        List<Integer> integers = adjList.get(neighbor);
                        integers.remove(Integer.valueOf(node));
                        if (integers.size() == 1) {
                            q.offer(neighbor);
                        }
                    }
                }
            }

            return q;
        }
    }
}
