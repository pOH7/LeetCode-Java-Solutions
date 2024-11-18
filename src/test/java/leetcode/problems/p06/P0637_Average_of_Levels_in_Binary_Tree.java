package leetcode.problems.p06;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Easy;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/18
 */
@Easy
public class P0637_Average_of_Levels_in_Binary_Tree {
    @Test
    void test1() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[3,9,20,null,null,15,7]");
        print(root);
        System.out.println(solution.averageOfLevels(root));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[3,9,20,15,7]");
        print(root);
        System.out.println(solution.averageOfLevels(root));
    }

    interface Solution {
        public List<Double> averageOfLevels(TreeNode root);
    }

    // 2 ms Beats 96.12%
    class Solution1 implements Solution {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offerLast(root);
            while (!q.isEmpty()) {
                double sum = 0;
                int num = q.size();
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.pollFirst();
                    sum += node.val;
                    if (node.left != null) {
                        q.offerLast(node.left);
                    }
                    if (node.right != null) {
                        q.offerLast(node.right);
                    }
                }
                ans.add(sum / num);
            }
            return ans;
        }
    }
}
