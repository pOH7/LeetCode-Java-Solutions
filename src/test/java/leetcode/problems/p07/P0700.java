package leetcode.problems.p07;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 700. Search in a Binary Search Tree
 *
 * @author zhanglei
 * @date 2022/3/21
 */
class P0700 {

    // improved interactive solution
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    /*
    // interactive solution
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) {
                return null;
            }
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                deque.push(node.left);
            } else {
                deque.push(node.right);
            }
        }
        return null;
    }
    */

    /*
    // recursive solution
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
    */

    @Test
    void test1() {
        Assertions.assertEquals("[2,1,3]", print(searchBST(newTreeNode(4, 2, 7, 1, 3), 2)));
    }

    @Test
    void test2() {
        Assertions.assertEquals("[]", print(searchBST(newTreeNode(4, 2, 7, 1, 3), 5)));
    }
}
