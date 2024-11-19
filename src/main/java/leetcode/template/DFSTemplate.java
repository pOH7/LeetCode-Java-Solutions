package leetcode.template;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
public class DFSTemplate {

    // 4. Matrix DFS with directions
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        DFSTemplate solution = new DFSTemplate();

        // Test matrix DFS
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        solution.matrixDFS(matrix, 0, 0);

        // Test graph DFS
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Arrays.asList());
        solution.graphDFS(graph, 0);
    }

    // 1. Recursive DFS for Tree
    public List<Integer> treeDFSRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfsHelper(root, result);
        return result;
    }

    private void dfsHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        // Pre-order traversal
        result.add(node.val);
        dfsHelper(node.left, result);
        dfsHelper(node.right, result);

        // For in-order traversal:
        // dfsHelper(node.left, result);
        // result.add(node.val);
        // dfsHelper(node.right, result);

        // For post-order traversal:
        // dfsHelper(node.left, result);
        // dfsHelper(node.right, result);
        // result.add(node.val);
    }

    // 2. Iterative DFS for Tree using Stack
    public List<Integer> treeDFSIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            // Push right first so left is processed first (LIFO)
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        return result;
    }

    // 3. Graph DFS with Adjacency List
    public void graphDFS(Map<Integer, List<Integer>> graph, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsGraph(graph, start, visited);
    }

    private void dfsGraph(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (!visited.add(node)) return; // If already visited, return

        System.out.println("Visiting node: " + node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            dfsGraph(graph, neighbor, visited);
        }
    }

    public void matrixDFS(int[][] matrix, int row, int col) {
        if (!isValid(matrix, row, col)) return;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfsMatrix(matrix, row, col, visited);
    }

    private void dfsMatrix(int[][] matrix, int row, int col, boolean[][] visited) {
        if (!isValid(matrix, row, col) || visited[row][col]) return;

        visited[row][col] = true;
        System.out.println("Visiting cell: " + matrix[row][col]);

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfsMatrix(matrix, newRow, newCol, visited);
        }
    }

    private boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    // 5. DFS with Path Recording
    public List<List<Integer>> findAllPaths(
            int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        List<List<Integer>> allPaths = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfsPath(matrix, startRow, startCol, endRow, endCol, visited, new ArrayList<>(), allPaths);
        return allPaths;
    }

    private void dfsPath(
            int[][] matrix,
            int row,
            int col,
            int endRow,
            int endCol,
            boolean[][] visited,
            List<Integer> currentPath,
            List<List<Integer>> allPaths) {
        if (!isValid(matrix, row, col) || visited[row][col]) return;

        currentPath.add(matrix[row][col]);
        visited[row][col] = true;

        if (row == endRow && col == endCol) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int[] dir : DIRECTIONS) {
                dfsPath(
                        matrix,
                        row + dir[0],
                        col + dir[1],
                        endRow,
                        endCol,
                        visited,
                        currentPath,
                        allPaths);
            }
        }

        visited[row][col] = false;
        currentPath.remove(currentPath.size() - 1);
    }

    // Tree Node definition
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
