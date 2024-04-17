package leetcode.problems.p06;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 617. Merge Two Binary Trees
 *
 * @link https://leetcode.com/problems/merge-two-binary-trees/
 * @author zhanglei
 * @date 2022/3/21
 */
class P0617 {

    // interactive solution
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root1);
        deque.offer(root2);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            node1.val += node2.val;

            if (node1.left == null) {
                node1.left = node2.left;
            } else if (node2.left != null) {
                deque.offer(node1.left);
                deque.offer(node2.left);
            }
            if (node1.right == null) {
                node1.right = node2.right;
            } else if (node2.right != null) {
                deque.offer(node1.right);
                deque.offer(node2.right);
            }
        }
        return root1;
    }

    /*
    // recursive solution
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
    */

    @Test
    void test1() {
        assertEquals(
                "[3,4,5,5,4,null,7]",
                print(mergeTrees(newTreeNode(1, 3, 2, 5), newTreeNode(2, 1, 3, null, 4, null, 7))));
    }

    @Test
    void test2() {
        assertEquals("[2,2]", print(mergeTrees(newTreeNode(1), newTreeNode(1, 2))));
    }
}
