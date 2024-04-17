package leetcode.problems.p01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/linked-list-cycle/
 * @author zhanglei
 * @date 2021/9/30
 */
public class P0141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static ListNode newListNode(int[] ints, int pos) {
            ListNode head = null;
            ListNode last = null;
            ListNode posNode = null;
            for (int j = 0; j < ints.length; j++) {
                int i = ints[j];
                if (head == null) {
                    last = new ListNode(i);
                    head = last;
                } else {
                    last.next = new ListNode(i);
                    last = last.next;
                }
                if (j == pos) {
                    posNode = last;
                }
            }
            last.next = posNode;
            return head;
        }
    }

    @Test
    void test() {
        int[] ints = {3, 2, 0, 4};
        ListNode listNode = ListNode.newListNode(ints, 1);
        Assertions.assertTrue(hasCycle(listNode));
    }

    @Test
    void test2() {
        int[] ints = {
            -21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13,
            -24, 21, 23, -21, 5
        };
        ListNode listNode = ListNode.newListNode(ints, -1);
        Assertions.assertFalse(hasCycle(listNode));
    }

    @Test
    void test3() {
        int[] ints = {1, 2};
        ListNode listNode = ListNode.newListNode(ints, 0);
        Assertions.assertTrue(hasCycle(listNode));
    }
}
