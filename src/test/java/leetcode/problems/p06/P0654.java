package leetcode.problems.p06;

import static leetcode.bean.TreeNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 654. Maximum Binary Tree
 *
 * @link https://leetcode.com/problems/maximum-binary-tree/
 * @reference
 *     https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution
 * @author zhanglei
 * @date 2022/3/17
 */
class P0654 {

    // O(n)
    // TODO clean code
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Deque<TreeNode> deque = new ArrayDeque<>(nums.length);
        deque.offerLast(new TreeNode(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            if (deque.peekLast().val > nums[i]) {
                deque.peekLast().right = new TreeNode(nums[i]);
                deque.offerLast(deque.peekLast().right);
            } else {
                TreeNode node = deque.pollLast();
                while (!deque.isEmpty() && deque.peekLast().val < nums[i]) {
                    node = deque.pollLast();
                }
                TreeNode temp = new TreeNode(nums[i]);
                temp.left = node;
                if (!deque.isEmpty()) {
                    deque.peekLast().right = temp;
                    deque.offerLast(deque.peekLast().right);
                } else {
                    deque.offerLast(temp);
                }
            }
        }
        return deque.peekFirst();
    }

    /*
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    static TreeNode constructMaximumBinaryTree(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int max = find(nums, s, e);
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(nums, s, max - 1);
        root.right = constructMaximumBinaryTree(nums, max + 1, e);
        return root;
    }

    static int find(int[] nums, int s, int e) {
        int max = s;
        for (int i = s + 1; i <= e; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
    */

    @Test
    void test1() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        assertEquals("[6,3,5,null,2,0,null,null,1]", print(constructMaximumBinaryTree(nums)));
    }

    @Test
    void test2() {
        int[] nums = {3, 2, 1};
        assertEquals("[3,null,2,null,1]", print(constructMaximumBinaryTree(nums)));
    }
}
