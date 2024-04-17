package leetcode.problems.p05;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 530. Minimum Absolute Difference in BST
 *
 * @link https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * @author zhanglei
 * @date 2022/3/22
 */
class P0530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        TreeNode current = root;
        int prev = -1;
        int min = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            while (current != null) {
                current = current.left;
                if (current != null) {
                    deque.offerLast(current);
                }
            }
            current = deque.pollLast();
            if (prev == -1) {
                prev = current.val;
            } else {
                if (current.val - prev < min) {
                    min = current.val - prev;
                    if (min == 1) {
                        return min;
                    }
                }
                prev = current.val;
            }
            current = current.right;
            if (current != null) {
                deque.offerLast(current);
            }
        }
        return min;
    }

    @Test
    void test1() {
        assertEquals(1, getMinimumDifference(newTreeNode(4, 2, 6, 1, 3)));
    }

    @Test
    void test2() {
        assertEquals(1, getMinimumDifference(newTreeNode(1, 0, 48, null, null, 12, 49)));
    }

    @Test
    void test35() {
        assertEquals(47, getMinimumDifference(newTreeNode(543, 384, 652, null, 445, null, 699)));
    }
}
