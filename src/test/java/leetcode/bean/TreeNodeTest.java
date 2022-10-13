package leetcode.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link
 *     https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation-
 * @author zhanglei
 * @version 2022/3/10
 */
class TreeNodeTest {
    @Test
    void test1() {
        TreeNode treeNode = TreeNode.newTreeNode();
        assertEquals("[]", TreeNode.print(treeNode));
    }

    @Test
    void test2() {
        TreeNode treeNode = TreeNode.newTreeNode(1, 2, 3);
        assertEquals("[1,2,3]", TreeNode.print(treeNode));
    }

    @Test
    void test3() {
        TreeNode treeNode = TreeNode.newTreeNode(1, null, 2, 3);
        assertEquals("[1,null,2,3]", TreeNode.print(treeNode));
    }

    @Test
    void test4() {
        TreeNode treeNode = TreeNode.newTreeNode(5, 4, 7, 3, null, 2, null, -1, null, 9);
        assertEquals("[5,4,7,3,null,2,null,-1,null,9]", TreeNode.print(treeNode));
    }
}
