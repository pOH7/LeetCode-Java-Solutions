package leetcode.problems.p06;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 669. Trim a Binary Search Tree
 *
 * @link https://leetcode.com/problems/trim-a-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/24
 */
class P0669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    @Test
    void test1() {
        assertEquals("[1,null,2]", print(trimBST(newTreeNode(1, 0, 2), 1, 2)));
    }

    @Test
    void test2() {
        assertEquals(
                "[3,2,null,1]", print(trimBST(newTreeNode(3, 0, 4, null, 2, null, null, 1), 1, 3)));
    }
}
