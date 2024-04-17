package leetcode.problems.p04;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 450. Delete Node in a BST
 *
 * @link https://leetcode.com/problems/delete-node-in-a-bst/
 * @refrence
 *     https://leetcode.com/problems/delete-node-in-a-bst/discuss/93298/Iterative-solution-in-Java-O(h)-time-and-O(1)-space
 * @author zhanglei
 * @date 2021/12/2
 */
class P0450 {
    // TODO improve
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            } else {
                int min = findMin(root.right);
                TreeNode node = new TreeNode(min);
                node.left = root.left;
                node.right = deleteNode(root.right, min);
                return node;
            }
        }
        return root;
    }

    static int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /*
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public int findMin(TreeNode root) {
        if (root.left != null) {
            return findMin(root.left);
        } else {
            return root.val;
        }
    }
    */

    @Test
    void test1() {
        assertEquals(
                "[5,4,6,2,null,null,7]", print(deleteNode(newTreeNode(5, 3, 6, 2, 4, null, 7), 3)));
    }

    @Test
    void test2() {
        assertEquals(
                "[5,3,6,2,4,null,7]", print(deleteNode(newTreeNode(5, 3, 6, 2, 4, null, 7), 0)));
    }

    @Test
    void test3() {
        assertEquals("[]", print(deleteNode(newTreeNode(), 0)));
    }

    @Test
    void test68() {
        assertEquals("[6,3,7,2,4]", print(deleteNode(newTreeNode(5, 3, 6, 2, 4, null, 7), 5)));
    }
}
