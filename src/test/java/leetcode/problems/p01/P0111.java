package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * @link https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0111 {
    public int minDepth(TreeNode root) {
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
                if (node.left == null && node.right == null) {
                    deque.clear();
                    break;
                }
            }
        }
        return depth;
    }

    @Test
    void test1() {
        assertEquals(2, minDepth(newTreeNode(3, 9, 20, null, null, 15, 7)));
    }

    @Test
    void test2() {
        assertEquals(5, minDepth(newTreeNode(2, null, 3, null, 4, null, 5, null, 6)));
    }
}
