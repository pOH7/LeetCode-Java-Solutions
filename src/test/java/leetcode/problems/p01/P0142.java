package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import leetcode.bean.ListNode;

import org.junit.jupiter.api.Test;

/**
 * 142. Linked List Cycle II
 *
 * @link https://leetcode.com/problems/linked-list-cycle-ii/
 * @author zhanglei
 * @date 2021/9/30
 */
class P0142 {

    /**
     *
     *
     * <pre>
     *     v: slow speed
     *     t: time
     *     A: distance between head to the beginning of the cycle
     *     X: distance between meet point to the beginning of the cycle
     *     ∵ vt = A + nB + X
     *       2vt = A + (n+1)B + X
     *     ∴ vt = B
     *     ∴ X = (1-n)B - A > 0
     *     ∴ meet point + A = the beginning of the cycle
     * </pre>
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    @Test
    void test1() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assertEquals(node2, detectCycle(node1));
    }

    @Test
    void test2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.next = node1;

        assertEquals(node1, detectCycle(node1));
    }

    @Test
    void test3() {
        ListNode node1 = new ListNode(1);

        assertNull(detectCycle(node1));
    }
}
