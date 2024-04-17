package leetcode.problems.p07;

import static leetcode.bean.TreeNode.newTreeNode;
import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 701. Insert into a Binary Search Tree
 *
 * @link https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/23
 */
class P0701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    @Test
    void test1() {
        assertEquals("[4,2,7,1,3,5]", print(insertIntoBST(newTreeNode(4, 2, 7, 1, 3), 5)));
    }

    @Test
    void test2() {
        assertEquals(
                "[40,20,60,10,30,50,70,null,null,25]",
                print(insertIntoBST(newTreeNode(40, 20, 60, 10, 30, 50, 70), 25)));
    }

    @Test
    void test3() {
        assertEquals(
                "[4,2,7,1,3,5]",
                print(
                        insertIntoBST(
                                newTreeNode(4, 2, 7, 1, 3, null, null, null, null, null, null),
                                5)));
    }
}
