package leetcode.problems.p06;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/18
 */
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

    class Solution1 implements Solution {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            // TODO
            return List.of();
        }
    }
}
