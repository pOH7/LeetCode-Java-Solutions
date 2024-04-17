package leetcode.problems.p05;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 513. Find Bottom Left Tree Value
 *
 * @link https://leetcode.com/problems/find-bottom-left-tree-value/
 * @author zhanglei
 * @date 2022/3/15
 */
class P0513 {

    // recursive solution
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int[] result = new int[] {-1, -1};
        findBottomLeftValue(root, 0, result);
        return result[1];
    }

    static void findBottomLeftValue(TreeNode root, int depth, int[] result) {
        if (result[0] < depth) {
            result[0] = depth;
            result[1] = root.val;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1, result);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1, result);
        }
    }

    /*
    // interactive solution
    public int findBottomLeftValue(TreeNode root) {
        int result = -1;
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            result = deque.peek().val;
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
        return result;
    }
    */

    @Test
    void test1() {
        assertEquals(1, findBottomLeftValue(newTreeNode(2, 1, 3)));
    }

    @Test
    void test2() {
        assertEquals(7, findBottomLeftValue(newTreeNode(1, 2, 3, 4, null, 5, 6, null, null, 7)));
    }
}
