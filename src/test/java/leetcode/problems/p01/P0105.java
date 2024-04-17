package leetcode.problems.p01;

import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @link https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author zhanglei
 * @date 2022/3/16
 */
class P0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    static TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        int rootVal = preorder[ps];
        int rootIndex = find(inorder, is, ie, rootVal);
        TreeNode root = new TreeNode(rootVal);
        // (ps + 1, r - is + ps) (pe - ie + r + 1, pe)
        // (is,     r - 1)       (r + 1,           ie)
        root.left = buildTree(preorder, ps + 1, rootIndex - is + ps, inorder, is, rootIndex - 1);
        root.right = buildTree(preorder, pe - ie + rootIndex + 1, pe, inorder, rootIndex + 1, ie);
        return root;
    }

    static int find(int[] inorder, int is, int ie, int rootVal) {
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    @Test
    void test1() {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        assertEquals("[3,9,20,null,null,15,7]", print(buildTree(preorder, inorder)));
    }

    @Test
    void test2() {
        int[] preorder = {-1}, inorder = {-1};
        assertEquals("[-1]", print(buildTree(preorder, inorder)));
    }
}
