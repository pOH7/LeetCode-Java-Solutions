package leetcode.problems.p01;

import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @link https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @refrence https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 * @author zhanglei
 * @date 2022/3/16
 */
class P0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    static TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        int rootVal = postorder[pe];
        int rootIndex = find(inorder, is, ie, rootVal);
        TreeNode root = new TreeNode(rootVal);
        if (rootIndex != is) {
            root.left =
                    buildTree(inorder, is, rootIndex - 1, postorder, ps, ps + rootIndex - 1 - is);
        }
        if (rootIndex != ie) {
            root.right =
                    buildTree(inorder, rootIndex + 1, ie, postorder, rootIndex + pe - ie, pe - 1);
        }
        return root;
    }

    static int find(int[] inorder, int i, int j, int val) {
        for (int k = i; k <= j; k++) {
            if (inorder[k] == val) {
                return k;
            }
        }
        return -1;
    }

    @Test
    void test1() {
        int[] inorder = {9, 3, 15, 20, 7}, postorder = {9, 15, 7, 20, 3};
        assertEquals("[3,9,20,null,null,15,7]", print(buildTree(inorder, postorder)));
    }

    @Test
    void test2() {
        int[] inorder = {-1}, postorder = {-1};
        assertEquals("[-1]", print(buildTree(inorder, postorder)));
    }

    @Test
    void test3() {
        int[] inorder = {2, 1}, postorder = {2, 1};
        assertEquals("[1,2]", print(buildTree(inorder, postorder)));
    }
}
