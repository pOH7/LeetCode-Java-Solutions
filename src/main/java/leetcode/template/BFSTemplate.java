package leetcode.template;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
public class BFSTemplate {

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

        BFSTemplate bfs = new BFSTemplate();
        bfs.bfs(node1);
    }

    public void bfs(Node startNode) {
        if (startNode == null) return;

        // Initialize a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        // Start with the given startNode
        queue.offer(startNode);
        visited.add(startNode);

        // Perform BFS
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // Process the current node
            System.out.println("Visited Node: " + currentNode.value);

            // Iterate through all neighbors
            for (Node neighbor : currentNode.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
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
