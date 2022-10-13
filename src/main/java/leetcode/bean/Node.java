package leetcode.bean;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglei
 * @date 2022/3/14
 */ // Definition for a Node.
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node newNode(Integer... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        Node root = new Node(vals[0]);
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        int index = 2;
        while (!deque.isEmpty()) {
            for (int i = 0, j = deque.size(); i < j; i++) {
                Node node = deque.poll();
                List<Node> tempList = new ArrayList<>();
                while (index < vals.length && vals[index++] != null) {
                    Node tempNode = new Node(vals[index - 1]);
                    tempList.add(tempNode);
                    deque.offer(tempNode);
                }
                node.children = tempList;
            }
        }
        return root;
    }
}
