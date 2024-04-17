package leetcode.problems.p02;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 * @link https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author zhanglei
 * @date 2022/3/22
 */
class P0236 {
    // iterative solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = deque.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                deque.offer(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                deque.offer(node.right);
            }
        }

        LinkedList<TreeNode> ps = findPath(p, parent);
        LinkedList<TreeNode> qs = findPath(q, parent);
        TreeNode result = null;
        while (ps.peek() == qs.peek()) {
            result = ps.pop();
            qs.pop();
        }
        return result;
    }

    static LinkedList<TreeNode> findPath(TreeNode p, Map<TreeNode, TreeNode> parent) {
        LinkedList<TreeNode> path = new LinkedList<>();
        TreeNode node = p;
        while (node != null) {
            path.add(0, node);
            node = parent.get(node);
        }
        return path;
    }

    /*
    // recursive solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }
    */

    /*
    // Time Limit Exceeded
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> ps = findPath(root, p, new LinkedList<>());
        LinkedList<TreeNode> qs = findPath(root, q, new LinkedList<>());
        TreeNode result = null;
        while (ps.peek() == qs.peek()) {
            result = ps.pop();
            qs.pop();
        }
        return result;
    }

    static LinkedList<TreeNode> findPath(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {
        path.add(root);
        if (root == p) {
            return path;
        }
        if (root.left != null) {
            LinkedList<TreeNode> path1 = findPath(root.left, p, clone(path));
            if (path1 != null) {
                return path1;
            }
        }
        if (root.right != null) {
            return findPath(root.right, p, clone(path));
        }

        return null;
    }

    static LinkedList<TreeNode> clone(LinkedList<TreeNode> path) {
        return new LinkedList<>(path);
    }
    */

    @Test
    void test1() {
        TreeNode root = newTreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        assertEquals(3, lowestCommonAncestor(root, root.node(5), root.node(1)).val);
    }

    @Test
    void test2() {
        TreeNode root = newTreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        assertEquals(5, lowestCommonAncestor(root, root.node(5), root.node(4)).val);
    }

    @Test
    void test3() {
        TreeNode root = newTreeNode(1, 2);
        assertEquals(1, lowestCommonAncestor(root, root.node(1), root.node(2)).val);
    }
}
