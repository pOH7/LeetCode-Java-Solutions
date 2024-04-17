package leetcode.problems.p08;

import static leetcode.bean.ListNode.newListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/middle-of-the-linked-list/
 * @author zhanglei
 * @date 2021/10/9
 */
public class P0876 {
    /** time complexity: O(n) space complexity: O(1) */
    public ListNode middleNode(ListNode head) {
        ListNode t = head;
        ListNode t2 = head;
        while (t2 != null && t2.next != null) {
            t2 = t2.next.next;
            t = t.next;
        }
        return t;
    }

    @Test
    void test1() {
        ListNode listNode = middleNode(newListNode(1, 2, 3, 4, 5));
        assertEquals("[3,4,5]", ListNode.print(listNode));
    }

    @Test
    void test2() {
        ListNode listNode = middleNode(newListNode(1, 2, 3, 4, 5, 6));
        assertEquals("[4,5,6]", ListNode.print(listNode));
    }
}
