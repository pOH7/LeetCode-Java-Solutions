package leetcode.template;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
public class KahnsAlgorithm {

    // Function to perform topological sorting using Kahn's Algorithm
    public static List<Integer> topologicalSort(int vertices, List<int[]> edges) {
        // Create an adjacency list and an array to store in-degrees
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[vertices];

        // Initialize the adjacency list
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list and in-degree array
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            adjList.get(from).add(to);
            inDegree[to]++;
        }

        // Initialize a queue and add all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Perform Kahn's Algorithm
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topologicalOrder.add(node);

            // Reduce the in-degree of all neighbors and add them to the queue if in-degree becomes
            // 0
            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check if there was a cycle
        if (topologicalOrder.size() != vertices) {
            throw new RuntimeException(
                    "The graph contains a cycle, and topological sorting is not possible.");
        }

        return topologicalOrder;
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        // Example: 6 vertices and a list of directed edges
        int vertices = 6;
        List<int[]> edges =
                Arrays.asList(
                        new int[] {5, 2},
                        new int[] {5, 0},
                        new int[] {4, 0},
                        new int[] {4, 1},
                        new int[] {2, 3},
                        new int[] {3, 1});

        try {
            List<Integer> result = topologicalSort(vertices, edges);
            System.out.println("Topological Sort: " + result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
