package leetcode.problems.p02;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 *
 * @link https://leetcode.com/problems/binary-tree-paths/
 * @author zhanglei
 * @date 2022/3/15
 */
class P0257 {
    // iterative solution
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<String> paths = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        paths.offerLast("");
        while (!deque.isEmpty()) {
            String path = paths.pollLast();
            TreeNode node = deque.pollLast();
            path += node.val;
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
                paths.offerLast(path + "->");
            }
            if (node.left != null) {
                deque.offerLast(node.left);
                paths.offerLast(path + "->");
            }
        }
        return result;
    }

    /*
    // recursive solution
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            preorderTraversal(root, new LinkedList<>(), result);
        }
        return result;
    }

    static void preorderTraversal(TreeNode root, Deque<String> path, List<String> result) {
        path.offerLast(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            result.add(String.join("->", path));
        }
        if (root.left != null) {
            preorderTraversal(root.left, path, result);
            path.pollLast();
        }
        if (root.right != null) {
            preorderTraversal(root.right, path, result);
            path.pollLast();
        }
    }
    */

    @Test
    void test1() {
        assertEquals("[1->2->5, 1->3]", binaryTreePaths(newTreeNode(1, 2, 3, null, 5)).toString());
    }

    @Test
    void test2() {
        assertEquals("[1]", binaryTreePaths(newTreeNode(1)).toString());
    }
}
