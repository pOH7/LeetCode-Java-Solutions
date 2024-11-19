package leetcode.problems.p01;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0107_Binary_Tree_Level_Order_Traversal_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
    }

    interface Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root);
    }

    // 1 ms Beats 93.96%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    level.add(node.val);
                }
                ans.add(0, level);
            }
            return ans;
        }
    }
}
