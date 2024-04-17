package leetcode.problems.p02;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 222. Count Complete Tree Nodes
 *
 * @link https://leetcode.com/problems/count-complete-tree-nodes/
 * @author zhanglei
 * @date 2022/3/14
 */
class P0222 {
    // time complexity: O(log(n)^2)
    // space complexity: O(log(n))
    public int countNodes(TreeNode root) {
        int height = height(root);
        if (height < 0) {
            return 0;
        }

        int rh = height(root.right);
        if (rh == height - 1) {
            // left is full, height(left) = h - 1
            return (1 << height) + countNodes(root.right);
        } else {
            // right is full, height(right) = h - 2
            return (1 << height - 1) + countNodes(root.left);
        }
    }

    static int height(TreeNode root) {
        int height = -1;
        TreeNode node = root;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    /*
    // time complexity: O(n)
    // space complexity: O(n)
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int size = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            size++;
            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
        }
        return size;
    }
    */

    @Test
    void test1() {
        assertEquals(6, countNodes(newTreeNode(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void test2() {
        assertEquals(0, countNodes(newTreeNode()));
    }

    @Test
    void test3() {
        assertEquals(1, countNodes(newTreeNode(1)));
    }
}
