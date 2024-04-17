package leetcode.problems.p05;

import static leetcode.bean.Node.newNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.Node;

import org.junit.jupiter.api.Test;

/**
 * 559. Maximum Depth of N-ary Tree
 *
 * @link https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * @author zhanglei
 * @date 2022/3/14
 */
class P0559 {
    // recursive solution
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            return 1;
        } else {
            return 1 + root.children.stream().mapToInt(this::maxDepth).max().orElse(0);
        }
    }

    /*
    // interactive solution
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            for (int i = 0, j = deque.size(); i < j; i++) {
                Node node = deque.poll();
                if (node.children != null) {
                    for (Node child : node.children) {
                        deque.offer(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
    */

    @Test
    void test1() {
        assertEquals(3, maxDepth(newNode(1, null, 3, 2, 4, null, 5, 6)));
    }

    @Test
    void test2() {
        assertEquals(
                5,
                maxDepth(
                        newNode(
                                1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null,
                                null, 11, null, 12, null, 13, null, null, 14)));
    }
}
