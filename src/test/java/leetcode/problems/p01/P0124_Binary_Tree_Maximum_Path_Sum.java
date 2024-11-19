package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 11/19/24
 */
@Hard
public class P0124_Binary_Tree_Maximum_Path_Sum {
    @Test
    void test1() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[1,2,3]");
        assertEquals(6, solution.maxPathSum(root));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[-10,9,20,null,null,15,7]");
        assertEquals(42, solution.maxPathSum(root));
    }

    @Test
    void test35() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[2,-1]");
        assertEquals(2, solution.maxPathSum(root));
    }

    @Test
    void test46() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[-3]");
        assertEquals(-3, solution.maxPathSum(root));
    }

    @Test
    void test73() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        assertEquals(48, solution.maxPathSum(root));
    }

    interface Solution {
        public int maxPathSum(TreeNode root);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public int maxPathSum(TreeNode root) {
            int[] ans = new int[] {Integer.MIN_VALUE};
            dsf(root, ans);
            return ans[0];
        }

        int dsf(TreeNode root, int[] ans) {
            if (root == null) {
                return 0;
            }

            int currentMax = root.val;
            int maxLeft = dsf(root.left, ans);
            if (maxLeft > 0) {
                currentMax += maxLeft;
            }
            int maxRight = dsf(root.right, ans);
            if (maxRight > 0) {
                currentMax += maxRight;
            }

            ans[0] = Math.max(ans[0], currentMax);
            // choose left or right or none to add to the current node
            return root.val + Math.max(Math.max(0, maxLeft), maxRight);
        }
    }
}
