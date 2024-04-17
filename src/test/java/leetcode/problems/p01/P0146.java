package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @link https://leetcode.com/problems/lru-cache/
 * @author zhanglei
 * @date 2021/11/15
 */
class P0146 {
    static class LRUCache {

        int maxLength;
        int currentLength;
        Map<Integer, Node> map;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);

        public LRUCache(int capacity) {
            maxLength = capacity;
            map = new HashMap<>(capacity);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            remove(node);
            insert(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                if (currentLength == maxLength) {
                    remove(tail.prev);
                }
            } else {
                remove(node);
            }
            insert(new Node(key, value));
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
            currentLength--;
        }

        public void insert(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            map.put(node.key, node);
            currentLength++;
        }
    }

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    @Test
    void test() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        assertEquals(1, lRUCache.get(1)); // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        assertEquals(-1, lRUCache.get(2)); // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        assertEquals(-1, lRUCache.get(1)); // return -1 (not found)
        assertEquals(3, lRUCache.get(3)); // return 3
        assertEquals(4, lRUCache.get(4)); // return 4
    }

    @Test
    void test2() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(2, 2);
        assertEquals(2, lRUCache.get(2));
        lRUCache.put(1, 1);
        lRUCache.put(4, 1);
        assertEquals(-1, lRUCache.get(2));
    }
}
