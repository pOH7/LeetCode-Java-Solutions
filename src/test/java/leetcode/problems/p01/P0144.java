package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * @link https://leetcode.com/problems/binary-tree-preorder-traversal/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0144 {

    // interactive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            result.add(node.val);
            if (node.right != null) {
                deque.offerLast(node.right);
            }
            if (node.left != null) {
                deque.offerLast(node.left);
            }
        }
        return result;
    }

    /*
    // recursive solution
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                preorderTraversal(root.left, result);
            }
            if (root.right != null) {
                preorderTraversal(root.right, result);
            }
        }
    }
    */

    @Test
    void test1() {
        assertEquals("[1, 2, 3]", preorderTraversal(newTreeNode(1, null, 2, 3)).toString());
    }

    @Test
    void test2() {
        assertEquals("[]", preorderTraversal(newTreeNode()).toString());
    }

    @Test
    void test3() {
        assertEquals("[1]", preorderTraversal(newTreeNode(1)).toString());
    }

    @Test
    void test52() {
        assertEquals("[1, 4, 2, 3]", preorderTraversal(newTreeNode(1, 4, 3, 2)).toString());
    }
}
