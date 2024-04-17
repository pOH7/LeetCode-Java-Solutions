package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @link https://leetcode.com/problems/binary-tree-postorder-traversal/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0145 {
    // recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<>());
    }

    static List<Integer> postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
        return result;
    }

    /*
    // iterative solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            result.add(node.val);
            if (node.left != null) {
                deque.offerLast(node.left);
            }
            if (node.right != null) {
                deque.offerLast(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
    */

    @Test
    void test1() {
        assertEquals("[3, 2, 1]", postorderTraversal(newTreeNode(1, null, 2, 3)).toString());
    }

    @Test
    void test2() {
        assertEquals("[]", postorderTraversal(newTreeNode()).toString());
    }

    @Test
    void test3() {
        assertEquals("[1]", postorderTraversal(newTreeNode(1)).toString());
    }
}
