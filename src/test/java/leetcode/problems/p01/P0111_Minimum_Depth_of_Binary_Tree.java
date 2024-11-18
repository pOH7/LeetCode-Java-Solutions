package leetcode.problems.p01;

import static leetcode.utils.LeetCodeUtils.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Easy;
import leetcode.utils.LeetCodeUtils.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @author zhanglei
 * @version 2024/11/18
 */
@Easy
public class P0111_Minimum_Depth_of_Binary_Tree {
    @Test
    void test1() {
        Solution solution = new Solution1();
        assertEquals(2, solution.minDepth(TreeNode.ofArrayString("[3,9,20,null,null,15,7]")));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        TreeNode root = TreeNode.ofArrayString("[2,null,3,null,4,null,5,null,6]");
        print(root);
        assertEquals(5, solution.minDepth(root));
    }

    interface Solution {
        public int minDepth(TreeNode root);
    }

    // 1 ms Beats 99.87%
    class Solution1 implements Solution {
        @Override
        public int minDepth(TreeNode root) {
            LinkedList<TreeNode> q = new LinkedList<>();
            int minDepth = 0;
            if (root != null) {
                q.offerLast(root);
            }
            while (!q.isEmpty()) {
                minDepth++;
                for (int i = q.size(); i > 0; i--) {
                    TreeNode node = q.pollFirst();
                    if (node.left != null) {
                        q.offerLast(node.left);
                    }
                    if (node.right != null) {
                        q.offerLast(node.right);
                    }
                    if (node.left == null && node.right == null) {
                        return minDepth;
                    }
                }
            }
            return minDepth;
        }
    }
}
