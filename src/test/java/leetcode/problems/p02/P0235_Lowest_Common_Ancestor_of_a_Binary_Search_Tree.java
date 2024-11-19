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
public class P0235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    @Test
    void test1() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = root.left;
        TreeNode q = root.right;
        assertEquals(6, solution.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = root.left;
        TreeNode q = root.left.right;
        assertEquals(2, solution.lowestCommonAncestor(root, p, q).val);
    }

    @Test
    void test16() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[2,1]");
        TreeNode p = root.left;
        TreeNode q = root;
        assertEquals(2, solution.lowestCommonAncestor(root, p, q).val);
    }

    interface Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);
    }

    // 5 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }
    }
}
