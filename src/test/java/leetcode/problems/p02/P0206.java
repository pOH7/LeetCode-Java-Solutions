package leetcode.problems.p02;

import static leetcode.bean.ListNode.newListNode;
import static leetcode.bean.ListNode.print;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.ListNode;

import org.junit.jupiter.api.Test;

/**
 * 206. Reverse Linked List
 *
 * @link https://leetcode.com/problems/reverse-linked-list/
 * @link
 *     https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
 * @author zhanglei
 * @date 2021/9/29
 */
public class P0206 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /*
    // iterative solution
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    */
    /*
    // recursive solution
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    ListNode reverseList(ListNode newHead, ListNode head) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(head, next);
    }
    */

    @Test
    void test1() {
        assertEquals("[5,4,3,2,1]", print(reverseList(newListNode(1, 2, 3, 4, 5))));
    }

    @Test
    void test2() {
        assertEquals("[2,1]", print(reverseList(newListNode(1, 2))));
    }

    @Test
    void test3() {
        assertEquals("[]", print(reverseList(newListNode())));
    }
}
