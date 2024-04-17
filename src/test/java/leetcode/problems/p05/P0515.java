package leetcode.problems.p05;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row
 *
 * @link https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = 0, j = deque.size(); i < j; i++) {
                TreeNode node = deque.poll();
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    @Test
    void test1() {
        assertEquals("[1, 3, 9]", largestValues(newTreeNode(1, 3, 2, 5, 3, null, 9)).toString());
    }

    @Test
    void test2() {
        assertEquals("[1, 3]", largestValues(newTreeNode(1, 2, 3)).toString());
    }
}
