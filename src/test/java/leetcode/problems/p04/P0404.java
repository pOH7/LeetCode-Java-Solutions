package leetcode.problems.p04;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

/**
 * 404. Sum of Left Leaves
 *
 * @link https://leetcode.com/problems/sum-of-left-leaves/
 * @author zhanglei
 * @date 2022/3/15
 */
class P0404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            } else {
                result += sumOfLeftLeaves(root.left);
            }
        }
        result += sumOfLeftLeaves(root.right);
        return result;
    }

    @Test
    void test1() {
        assertEquals(24, sumOfLeftLeaves(newTreeNode(3, 9, 20, null, null, 15, 7)));
    }

    @Test
    void test2() {
        assertEquals(0, sumOfLeftLeaves(newTreeNode(1)));
    }
}
