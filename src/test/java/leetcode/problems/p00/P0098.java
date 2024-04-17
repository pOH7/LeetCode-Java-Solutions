package leetcode.problems.p00;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 98. Validate Binary Search Tree
 *
 * @link https://leetcode.com/problems/validate-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/21
 */
class P0098 {

    // interactive solution
    // TODO improve inorder traversal
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<Object> deque = new ArrayDeque<>();
        deque.offerLast(root);
        Integer pre = null;
        while (!deque.isEmpty()) {
            if (deque.peekLast() instanceof TreeNode) {
                TreeNode node = (TreeNode) deque.pollLast();
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
                deque.offerLast(node.val);
                if (node.left != null) {
                    deque.offerLast(node.left);
                }
            } else {
                if (pre != null) {
                    if (valOf(deque.peekLast()) <= pre) {
                        return false;
                    }
                }
                pre = (Integer) deque.pollLast();
            }
        }
        return true;
    }

    static int valOf(Object obj) {
        if (obj instanceof TreeNode) {
            return ((TreeNode) obj).val;
        } else {
            return (Integer) obj;
        }
    }

    /*
    // recursive solution
    public boolean isValidBST(TreeNode root) {
        return root == null
                || (root.left == null || max(root.left) < root.val && isValidBST(root.left))
                        && (root.right == null
                                || min(root.right) > root.val && isValidBST(root.right));
    }

    static int min(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    static int max(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
    */

    @Test
    void test1() {
        assertTrue(isValidBST(newTreeNode(2, 1, 3)));
    }

    @Test
    void test2() {
        assertFalse(isValidBST(newTreeNode(5, 1, 4, null, null, 3, 6)));
    }

    @Test
    void test10() {
        assertTrue(isValidBST(newTreeNode(0, null, 1)));
    }

    @Test
    void test57() {
        assertFalse(isValidBST(newTreeNode(2, 2, 2)));
    }

    @Test
    void test61() {
        assertFalse(isValidBST(newTreeNode(1, 1)));
    }

    @Test
    void test72() {
        assertFalse(isValidBST(newTreeNode(5, 4, 6, null, null, 3, 7)));
    }

    @Test
    void test75() {
        assertFalse(isValidBST(newTreeNode(5, 4, 6, null, null, 3, 7)));
    }
}
