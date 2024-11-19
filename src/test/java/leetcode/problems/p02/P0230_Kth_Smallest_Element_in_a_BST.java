package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
@Medium
public class P0230_Kth_Smallest_Element_in_a_BST {
    @Test
    void test1() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[3,1,4,null,2]");
        int k = 1;
        assertEquals(1, solution.kthSmallest(root, k));
    }

    interface Solution {
        public int kthSmallest(TreeNode root, int k);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public int kthSmallest(TreeNode root, int k) {
            return dfs(root, k, new int[1]);
        }

        int dfs(TreeNode root, int k, int[] count) {
            if (root == null) {
                return -1;
            }
            int left = dfs(root.left, k, count);
            if (left != -1) {
                return left;
            }
            count[0]++;
            if (count[0] == k) {
                return root.val;
            }
            return dfs(root.right, k, count);
        }
    }
}
