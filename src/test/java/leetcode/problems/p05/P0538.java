package leetcode.problems.p05;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 538. Convert BST to Greater Tree
 *
 * @link https://leetcode.com/problems/convert-bst-to-greater-tree/
 * @author zhanglei
 * @date 2022/3/24
 */
class P0538 {

    // recursive solution
    public TreeNode convertBST(TreeNode root) {
        int[] total = new int[1];
        convertBST(root, total);
        return root;
    }

    TreeNode convertBST(TreeNode root, int[] total) {
        if (root == null) {
            return null;
        }
        root.right = convertBST(root.right, total);
        total[0] += root.val;
        root.val = total[0];
        root.left = convertBST(root.left, total);
        return root;
    }

    /*
    // iterative solution
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int total = 0;
        TreeNode current = root;
        while (!deque.isEmpty()) {
            while (current != null) {
                current = current.right;
                if (current != null) {
                    deque.offerLast(current);
                }
            }
            TreeNode node = deque.pollLast();
            total += node.val;
            node.val = total;
            current = node.left;
            if (current != null) {
                deque.offerLast(current);
            }
        }
        return root;
    }
    */

    @Test
    void test1() {
        assertEquals(
                "[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]",
                print(
                        convertBST(
                                newTreeNode(
                                        4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null,
                                        8))));
    }

    @Test
    void test2() {
        assertEquals("[1,null,1]", print(convertBST(newTreeNode(0, null, 1))));
    }
}
