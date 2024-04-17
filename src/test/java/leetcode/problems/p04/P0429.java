package leetcode.problems.p04;

import static leetcode.bean.Node.newNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.Node;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 *
 * @link https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0, j = deque.size(); i < j; i++) {
                Node node = deque.poll();
                currentLevel.add(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        deque.offer(child);
                    }
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    @Test
    void test1() {
        assertEquals(
                "[[1], [3, 2, 4], [5, 6]]",
                levelOrder(newNode(1, null, 3, 2, 4, null, 5, 6)).toString());
    }

    @Test
    void test2() {
        assertEquals(
                "[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]".replace(",", ", "),
                levelOrder(
                                newNode(
                                        1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10,
                                        null, null, 11, null, 12, null, 13, null, null, 14))
                        .toString());
    }
}
