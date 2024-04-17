package leetcode.problems.p01;

import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * @link https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/24
 */
class P0108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + high >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, high);
        return root;
    }

    @Test
    void test1() {
        int[] nums = {-10, -3, 0, 5, 9};
        assertTrue(
                Arrays.asList("[0,-3,9,-10,null,5]", "[0,-10,5,null,-3,null,9]")
                        .contains(print(sortedArrayToBST(nums))));
    }

    @Test
    void test2() {
        int[] nums = {1, 3};
        assertTrue(Arrays.asList("[3,1]", "[1,null,3]").contains(print(sortedArrayToBST(nums))));
    }
}
