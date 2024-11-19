package leetcode.problems.p01;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0103_Binary_Tree_Zigzag_Level_Order_Traversal {
    @Test
    void test1() {
        Solution solution = new Solution1();
        System.out.println(
                solution.zigzagLevelOrder(TreeNode.ofArrayString("[3,9,20,null,null,15,7]")));
    }

    @Test
    void test14() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[1,2,3,4,null,null,5]");
        print(root);
        System.out.println(solution.zigzagLevelOrder(root));
    }

    interface Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root);
    }

    // 1 ms Beats 71.08%
    class Solution1 implements Solution {
        @Override
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int round = 0;
            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.poll();
                    if ((round & 1) == 0) {
                        level.add(node.val);
                    } else {
                        level.add(0, node.val);
                    }

                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                ans.add(level);
                round++;
            }
            return ans;
        }
    }
}
