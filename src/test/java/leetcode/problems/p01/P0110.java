package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 110. Balanced Binary Tree
 *
 * @link https://leetcode.com/problems/balanced-binary-tree/
 * @author zhanglei
 * @date 2022/3/15
 */
class P0110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != Integer.MIN_VALUE;
    }

    static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = height(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = height(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Test
    void test1() {
        assertTrue(isBalanced(newTreeNode(3, 9, 20, null, null, 15, 7)));
    }

    @Test
    void test2() {
        assertFalse(isBalanced(newTreeNode(1, 2, 2, 3, 3, null, null, 4, 4)));
    }

    @Test
    void test3() {
        assertTrue(isBalanced(newTreeNode()));
    }

    @Test
    void test219() {
        assertTrue(isBalanced(newTreeNode(1, 2, 3, 4, 5, 6, null, 8)));
    }
}
