package leetcode.problems.p08;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0863_All_Nodes_Distance_K_in_Binary_Tree {
    @Test
    void test1() {
        Solution solution = new Solution2();
        TreeNode root = TreeNode.ofArrayString("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode target = root.left;
        int k = 2;
        System.out.println(solution.distanceK(root, target, k));
    }

    interface Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k);
    }

    // 17 ms Beats 6.01%
    class Solution1 implements Solution {

        @Override
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    graph.computeIfAbsent(node, o -> new ArrayList<>()).add(node.left);
                    graph.computeIfAbsent(node.left, o -> new ArrayList<>()).add(node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    graph.computeIfAbsent(node, o -> new ArrayList<>()).add(node.right);
                    graph.computeIfAbsent(node.right, o -> new ArrayList<>()).add(node);
                    q.offer(node.right);
                }
            }

            Set<TreeNode> visited = new HashSet<>();
            q.clear();
            q.offer(target);
            visited.add(target);
            int distance = 0;
            while (!q.isEmpty()) {
                if (distance == k) {
                    return q.stream().map(n -> n.val).toList();
                }
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    if (!graph.containsKey(node)) {
                        return List.of();
                    }
                    for (TreeNode neighbour : graph.get(node)) {
                        if (!visited.contains(neighbour)) {
                            q.offer(neighbour);
                            visited.add(neighbour);
                        }
                    }
                }
                distance++;
            }

            return List.of();
        }
    }

    // 15 ms Beats 24.20%
    class Solution2 implements Solution {

        @Override
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    q.offer(node.right);
                }
            }

            q.offer(target);
            int distance = 0;
            Set<TreeNode> visited = new HashSet<>();
            visited.add(target);
            while (!q.isEmpty()) {
                if (distance == k) {
                    return q.stream().map(n -> n.val).toList();
                }
                distance++;
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    if (node.left != null && !visited.contains(node.left)) {
                        q.offer(node.left);
                        visited.add(node.left);
                    }
                    if (node.right != null && !visited.contains(node.right)) {
                        q.offer(node.right);
                        visited.add(node.right);
                    }
                    TreeNode o = parentMap.get(node);
                    if (o != null && !visited.contains(o)) {
                        q.offer(o);
                        visited.add(o);
                    }
                }
            }

            return List.of();
        }
    }
}
