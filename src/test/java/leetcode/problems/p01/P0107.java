package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0, j = deque.size(); i < j; i++) {
                TreeNode node = deque.poll();
                currentLevel.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        Collections.reverse(result);
        return result;
    }

    @Test
    void test1() {
        assertEquals(
                "[[15, 7], [9, 20], [3]]",
                levelOrderBottom(newTreeNode(3, 9, 20, null, null, 15, 7)).toString());
    }

    @Test
    void test2() {
        assertEquals("[[1]]", levelOrderBottom(newTreeNode(1)).toString());
    }

    @Test
    void test3() {
        assertEquals("[]", levelOrderBottom(newTreeNode()).toString());
    }
}
