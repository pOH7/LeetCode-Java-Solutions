package leetcode.template;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
public class BFSWithDepth {

    public static void main(String[] args) {
        // Example usage:
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Constructing a simple graph
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        BFSWithDepth bfs = new BFSWithDepth();
        int totalDepth = bfs.bfsWithDepth(node1);
        System.out.println("Total Depth: " + totalDepth);
    }

    public int bfsWithDepth(Node startNode) {
        if (startNode == null) return 0;

        // Initialize a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        int depth = 0;

        // Start with the given startNode
        queue.offer(startNode);
        visited.add(startNode);

        // Perform BFS with depth tracking
        while (!queue.isEmpty()) {
            depth++; // Increment depth for each level
            int levelSize = queue.size(); // Number of nodes at the current level

            // Process all nodes at the current depth level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // Process the current node (e.g., print it)
                System.out.println("Visited Node: " + currentNode.value + " at Depth: " + depth);

                // Iterate through all neighbors
                for (Node neighbor : currentNode.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return depth; // Return the total depth of the traversal
    }

    // Node class to represent each node in the graph or tree
    static class Node {
        int value;
        List<Node> neighbors; // For graph representation

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }
    }
}
