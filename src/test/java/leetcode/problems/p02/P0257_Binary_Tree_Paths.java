package leetcode.problems.p02;

import leetcode.difficulty.Easy;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhanglei
 * @version 11/15/24
 */
@Easy
public class P0257_Binary_Tree_Paths {
    @Test
    void test1() {
        Solution solution = new Solution2();
        System.out.println(solution.binaryTreePaths(TreeNode.ofArrayString("[1,2,3,null,5]")));
    }

    @Test
    void test2() {
        Solution solution = new Solution2();
        System.out.println(solution.binaryTreePaths(TreeNode.ofArrayString("[1]")));
    }

    interface Solution {
        public List<String> binaryTreePaths(TreeNode root);
    }

    class Solution1 implements Solution {
        @Override
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<String> paths = new LinkedList<>();
            Deque<TreeNode> q = new LinkedList<>();
            q.offerLast(root);
            paths.offerLast("");
            while (!q.isEmpty()) {
                TreeNode node = q.pollLast();
                String path = paths.pollLast();
                if (node.left != null) {
                    paths.offerLast(path + node.val + "->");
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    paths.offerLast(path + node.val + "->");
                    q.offerLast(node.right);
                }
                if (node.left == null && node.right == null) {
                    result.add(path + node.val);
                }
            }
            return result;
        }
    }

    class Solution2 implements Solution {

        @Override
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            binaryTreePaths(root, result, sb);
            return result;
        }

        public void binaryTreePaths(TreeNode root, List<String> result, StringBuilder sb) {
            if (root == null) {
                return;
            }

            int len = sb.length();
            sb.append(root.val);

            if (root.left == null && root.right == null) {
                result.add(sb.toString());
            } else {
                sb.append("->");
                binaryTreePaths(root.left, result, sb);
                binaryTreePaths(root.right, result, sb);
            }
            sb.setLength(len);
        }
    }
}
