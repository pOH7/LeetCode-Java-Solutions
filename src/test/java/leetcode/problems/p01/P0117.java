package leetcode.problems.p01;

import static leetcode.problems.p01.P0116.Node.newNode;
import static leetcode.problems.p01.P0116.Node.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.problems.p01.P0116.Node;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            for (int i = 0, j = deque.size(); i < j; i++) {
                Node node = deque.poll();
                if (i + 1 != j) {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    @Test
    void test1() {
        assertEquals("[1,#,2,3,#,4,5,7,#]", print(connect(newNode(1, 2, 3, 4, 5, null, 7))));
    }

    @Test
    void test2() {
        assertEquals("[]", print(connect(newNode())));
    }
}
