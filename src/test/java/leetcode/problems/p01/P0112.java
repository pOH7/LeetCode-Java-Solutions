package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 112. Path Sum
 *
 * @link https://leetcode.com/problems/path-sum/
 * @author zhanglei
 * @date 2022/3/16
 */
class P0112 {

    // interactive solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        Deque<Integer> result = new LinkedList<>();
        result.offer(0);
        while (!deque.isEmpty()) {
            for (int i = 0, j = deque.size(); i < j; i++) {
                TreeNode node = deque.poll();
                Integer sum = result.poll() + node.val;
                if (targetSum == sum && node.left == null && node.right == null) {
                    return true;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                    result.offer(sum);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                    result.offer(sum);
                }
            }
        }
        return false;
    }

    /*
    // recursive solution
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return root != null
                && (root.val == targetSum && root.left == null && root.right == null
                        || hasPathSum(root.left, targetSum - root.val)
                        || hasPathSum(root.right, targetSum - root.val));
    }
    */

    @Test
    void test1() {
        assertTrue(
                hasPathSum(newTreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22));
    }

    @Test
    void test2() {
        assertFalse(hasPathSum(newTreeNode(1, 2, 3), 5));
    }

    @Test
    void test3() {
        assertFalse(hasPathSum(newTreeNode(), 0));
    }

    @Test
    void test71() {
        assertFalse(hasPathSum(newTreeNode(1, 2), 1));
    }

    @Test
    void test83() {
        assertTrue(hasPathSum(newTreeNode(-2, null, -3), -5));
    }
}
