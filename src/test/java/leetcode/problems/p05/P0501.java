package leetcode.problems.p05;

import static leetcode.bean.TreeNode.newTreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.TreeNode;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * @link https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * @author zhanglei
 * @date 2022/3/22
 */
class P0501 {
    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int frequency = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = root;
        deque.offerLast(current);
        Integer prev = null;
        int currFrequency = 0;
        while (!deque.isEmpty()) {
            while (current != null) {
                current = current.left;
                if (current != null) {
                    deque.offerLast(current);
                }
            }
            current = deque.pollLast();
            if (prev == null) {
                prev = current.val;
                currFrequency++;
            } else if (current.val != prev) {
                if (currFrequency > frequency) {
                    result.clear();
                    result.add(prev);
                    frequency = currFrequency;
                } else if (currFrequency == frequency) {
                    result.add(prev);
                }
                currFrequency = 1;
                prev = current.val;
            } else {
                currFrequency++;
            }
            current = current.right;
            if (current != null) {
                deque.offerLast(current);
            }
        }
        if (currFrequency > frequency) {
            result.clear();
            result.add(prev);
        } else if (currFrequency == frequency) {
            result.add(prev);
        }
        return result.stream().mapToInt(i -> (int) i).toArray();
    }

    @Test
    void test1() {
        assertEquals("[2]", Arrays.toString(findMode(newTreeNode(1, null, 2, 2))));
    }

    @Test
    void test2() {
        assertEquals("[0]", Arrays.toString(findMode(newTreeNode(0))));
    }
}
