package leetcode.problems.p00;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        TreeNode current = root;
        while (!deque.isEmpty()) {
            while (current != null) {
                current = current.left;
                if (current != null) {
                    deque.offerLast(current);
                }
            }
            current = deque.pollLast();
            result.add(current.val);
            current = current.right;
            if (current != null) {
                deque.offerLast(current);
            }
        }
        return result;
    }

    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque deque = new LinkedList();
        deque.offerLast(root);
        while (!deque.isEmpty()) {
            Object obj = deque.pollLast();
            if (obj instanceof TreeNode) {
                TreeNode node = (TreeNode) obj;
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
                deque.offerLast(node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
            } else {
                result.add((Integer) obj);
            }
        }
        return result;
    }
    */

    @Test
    void test1() {
        assertEquals("[1, 3, 2]", inorderTraversal(newTreeNode(1, null, 2, 3)).toString());
    }

    @Test
    void test2() {
        assertEquals("[]", inorderTraversal(newTreeNode()).toString());
    }

    @Test
    void test3() {
        assertEquals("[1]", inorderTraversal(newTreeNode(1)).toString());
    }
}
