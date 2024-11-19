package leetcode.problems.p01;

import static leetcode.utils.LeetCodeUtils.print;

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
public class P0199_Binary_Tree_Right_Side_View {
    @Test
    void test1() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[1,2,3,null,5,null,4]");
        print(root);
        System.out.println(solution.rightSideView(root));
    }

    interface Solution {
        public List<Integer> rightSideView(TreeNode root);
    }

    // 1 ms Beats 67.65%
    class Solution1 implements Solution {
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    if (i == 1) {
                        ans.add(node.val);
                    }
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
            }
            return ans;
        }
    }
}
