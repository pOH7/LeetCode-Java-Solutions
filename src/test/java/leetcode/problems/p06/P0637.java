package leetcode.problems.p06;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 *
 * @link https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            double sum = 0;
            int num = deque.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = deque.poll();
                sum += node.val;
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(sum / num);
        }
        return result;
    }

    @Test
    void test1() {
        assertEquals(
                "[3.00000, 14.50000, 11.00000]".replace("0000", ""),
                averageOfLevels(newTreeNode(3, 9, 20, null, null, 15, 7)).toString());
    }

    @Test
    void test2() {
        assertEquals(
                "[3.00000, 14.50000, 11.00000]".replace("0000", ""),
                averageOfLevels(newTreeNode(3, 9, 20, 15, 7)).toString());
    }
}
