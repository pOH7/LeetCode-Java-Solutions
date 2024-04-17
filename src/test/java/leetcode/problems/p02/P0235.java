package leetcode.problems.p02;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/23
 */
class P0235 {

    // iterative solution 2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }

    /*
    // recursive solution 2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
    */

    /*
    // recursive solution 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null
                || root == p
                || root == q
                || (root.val < p.val && root.val > q.val)
                || (root.val > p.val && root.val < q.val)) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    */

    /*
    // iterative solution 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ps = findPath(root, p);
        LinkedList<TreeNode> qs = findPath(root, q);

        TreeNode result = null;
        while (ps.peekFirst() == qs.peekFirst()) {
            result = ps.pollFirst();
            qs.pollFirst();
        }
        return result;
    }

    static LinkedList<TreeNode> findPath(TreeNode root, TreeNode p) {
        LinkedList<TreeNode> path = new LinkedList<>();
        while (root != p) {
            path.add(root);
            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        path.add(p);
        return path;
    }
    */

    @Test
    void test1() {
        TreeNode root = newTreeNode(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertEquals(6, lowestCommonAncestor(root, root.node(2), root.node(8)).val);
    }

    @Test
    void test2() {
        TreeNode root = newTreeNode(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        assertEquals(2, lowestCommonAncestor(root, root.node(2), root.node(4)).val);
    }

    @Test
    void test3() {
        TreeNode root = newTreeNode(2, 1);
        assertEquals(2, lowestCommonAncestor(root, root.node(2), root.node(1)).val);
    }
}
