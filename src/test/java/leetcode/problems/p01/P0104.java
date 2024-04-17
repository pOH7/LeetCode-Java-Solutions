package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @link https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0104 {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            depth++;
            for (int i = 0, j = deque.size(); i < j; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }

    @Test
    void test1() {
        assertEquals(3, maxDepth(newTreeNode(3, 9, 20, null, null, 15, 7)));
    }

    @Test
    void test2() {
        assertEquals(2, maxDepth(newTreeNode(1, null, 2)));
    }
}
