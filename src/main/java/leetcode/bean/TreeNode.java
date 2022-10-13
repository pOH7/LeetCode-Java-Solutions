package leetcode.bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author zhanglei
 * @date 2021/12/2
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode node(int val) {
        if (this.val == val) {
            return this;
        }
        if (this.left != null) {
            TreeNode node = this.left.node(val);
            if (node != null) {
                return node;
            }
        }
        if (this.right != null) {
            return this.right.node(val);
        }
        return null;
    }

    public static TreeNode newTreeNode(Integer... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < vals.length; i += 2) {
            TreeNode node = queue.poll();
            if (vals[i] != null) {
                queue.offer(node.left = new TreeNode(vals[i]));
            }
            if (i + 1 < vals.length && vals[i + 1] != null) {
                queue.offer(node.right = new TreeNode(vals[i + 1]));
            }
        }
        return root;
    }

    public static String print(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i) == null) {
                result.remove(i);
            } else {
                break;
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }
}
