package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. Symmetric Tree
 *
 * @link https://leetcode.com/problems/symmetric-tree/
 * @author zhanglei
 * @date 2022/3/14
 */
class P0101 {

    // interactive solution
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> l = new LinkedList<>();
        Deque<TreeNode> r = new LinkedList<>();
        l.push(root.left);
        r.push(root.right);
        while (!l.isEmpty() && !r.isEmpty()) {
            TreeNode left = l.pop();
            TreeNode right = r.pop();
            if (left == null && right == null) {
                continue;
            } else if (left != null && right != null && left.val == right.val) {
                l.push(left.left);
                l.push(left.right);
                r.push(right.right);
                r.push(right.left);
            } else {
                return false;
            }
        }
        return l.isEmpty() && r.isEmpty();
    }

    /*
    // recursive solution
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l != null && r != null) {
            return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
        } else {
            return l == null && r == null;
        }
    }
    */

    @Test
    void test1() {
        assertTrue(isSymmetric(newTreeNode(1, 2, 2, 3, 4, 4, 3)));
    }

    @Test
    void test2() {
        assertFalse(isSymmetric(newTreeNode(1, 2, 2, null, 3, null, 3)));
    }

    @Test
    void test166() {
        assertFalse(isSymmetric(newTreeNode(1, 2, 3)));
    }
}
