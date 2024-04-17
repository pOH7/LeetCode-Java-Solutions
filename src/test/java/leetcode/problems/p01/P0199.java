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
 * 199. Binary Tree Right Side View
 *
 * @link https://leetcode.com/problems/binary-tree-right-side-view/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            for (int i = 0, j = deque.size(); i < j; i++) {
                TreeNode node = deque.poll();
                if (i + 1 == j) {
                    result.add(node.val);
                }
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

    @Test
    void test1() {
        assertEquals("[1, 3, 4]", rightSideView(newTreeNode(1, 2, 3, null, 5, null, 4)).toString());
    }

    @Test
    void test2() {
        assertEquals("[1, 3]", rightSideView(newTreeNode(1, null, 3)).toString());
    }

    @Test
    void test3() {
        assertEquals("[]", rightSideView(newTreeNode()).toString());
    }
}
