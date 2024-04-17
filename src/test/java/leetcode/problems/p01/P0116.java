package leetcode.problems.p01;

import static leetcode.problems.p01.P0116.Node.newNode;
import static leetcode.problems.p01.P0116.Node.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 116. Populating Next Right Pointers in Each Node
 *
 * @link https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * @author zhanglei
 * @date 2022/3/10
 */
class P0116 {
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

    // Definition for a Node.
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public static Node newNode(Integer... vals) {
            if (vals == null || vals.length == 0) {
                return null;
            }
            Node root = new Node(vals[0]);
            Deque<Node> deque = new LinkedList<>();
            deque.offer(root);
            int i = 1;
            while (i < vals.length && !deque.isEmpty()) {
                Node node = deque.poll();
                if (vals[i] != null) {
                    deque.offer(node.left = new Node(vals[i]));
                }
                if (vals[i + 1] != null) {
                    deque.offer(node.right = new Node(vals[i + 1]));
                }
                i += 2;
            }
            return root;
        }

        public static String print(Node node) {
            if (node == null) {
                return "[]";
            }
            List<String> result = new ArrayList<>();
            while (node != null) {
                result.add(String.valueOf(node.val));
                Node next = node.next;
                while (next != null) {
                    result.add(String.valueOf(next.val));
                    next = next.next;
                }
                result.add("#");
                node = node.left;
            }
            return result.stream().collect(Collectors.joining(",", "[", "]"));
        }
    }

    @Test
    void test1() {
        assertEquals("[1,#,2,3,#,4,5,6,7,#]", print(connect(newNode(1, 2, 3, 4, 5, 6, 7))));
    }

    @Test
    void test2() {
        assertEquals("[]", print(connect(newNode())));
    }
}
