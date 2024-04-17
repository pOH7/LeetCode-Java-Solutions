package leetcode.problems.p07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

/**
 * 707. Design Linked List
 *
 * @link https://leetcode.com/problems/design-linked-list/
 * @author zhanglei
 * @date 2022/2/23
 */
@Slf4j
class P0707 {
    static class MyLinkedList {

        static class Node {
            int val;
            Node next;

            public Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }

            public Node(int val) {
                this(val, null);
            }
        }

        Node dummyHead;
        int size;

        public MyLinkedList() {
            dummyHead = new Node(0);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node cur = dummyHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            Node cur = dummyHead;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            cur.next = new Node(val, cur.next);
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            Node cur = dummyHead;
            for (int i = 1; i <= index; i++) {
                cur = cur.next;
            }
            Node t = cur.next;
            if (t == null) {
                return;
            }
            cur.next = t.next;
            t.next = null;
            size--;
        }
    }

    @Test
    void test1() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        assertEquals(2, myLinkedList.get(1)); // return 2
        myLinkedList.deleteAtIndex(1); // now the linked list is 1->3
        assertEquals(3, myLinkedList.get(1)); // return 3
    }

    @Test
    void test2() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        assertEquals(2, myLinkedList.get(0));
    }

    @Test
    void test3() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        assertEquals(3, myLinkedList.get(1));
        assertEquals(-1, myLinkedList.get(3));
        myLinkedList.deleteAtIndex(3);
        myLinkedList.deleteAtIndex(0);
        assertEquals(3, myLinkedList.get(0));
        myLinkedList.deleteAtIndex(0);
        assertEquals(-1, myLinkedList.get(0));
    }
}
