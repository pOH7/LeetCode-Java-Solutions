package leetcode.problems.p01;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return result;
    }

    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        List<Integer> currentLevel = new ArrayList<>();
        int i = 0;
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            i++;
            currentLevel.add(node.val);
            if (node.left != null) {
                deque.offer(node.left);
                nextLevelNum++;
            }
            if (node.right != null) {
                deque.offer(node.right);
                nextLevelNum++;
            }
            if (i == currentLevelNum) {
                i = 0;
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                result.add(currentLevel);
                currentLevel = new ArrayList<>();
            }
        }
        return result;
    }
    */

    @Test
    void test1() {
        assertEquals(
                "[[3], [9, 20], [15, 7]]",
                levelOrder(newTreeNode(3, 9, 20, null, null, 15, 7)).toString());
    }

    @Test
    void test2() {
        assertEquals("[[1]]", levelOrder(newTreeNode(1)).toString());
    }

    @Test
    void test3() {
        assertEquals("[]", levelOrder(newTreeNode()).toString());
    }
}
