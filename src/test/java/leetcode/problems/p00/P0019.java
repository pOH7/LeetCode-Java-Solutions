package leetcode.problems.p00;

import leetcode.bean.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.bean.ListNode.newListNode;
import static leetcode.bean.ListNode.print;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 19. Remove Nth Node From End of List
 *
 * @link https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * @author zhanglei
 * @date 2021/10/9
 */
class P0019 {

    /** time complexity: O(n) space complexity: O(1) */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode t = dummy;
        ListNode nt = t;
        while (n > 0) {
            nt = nt.next;
            n--;
        }
        while (nt.next != null) {
            t = t.next;
            nt = nt.next;
        }
        ListNode temp = t.next;
        t.next = temp.next;
        temp.next = null;
        return dummy.next;
    }

    @Test
    void test1() {
        ListNode listNode = removeNthFromEnd(newListNode(1, 2, 3, 4, 5), 2);
        assertEquals("[1,2,3,5]", print(listNode));
    }

    @Test
    void test2() {
        ListNode listNode = removeNthFromEnd(newListNode(1), 1);
        assertEquals("[]", print(listNode));
    }

    @Test
    void test3() {
        ListNode listNode = removeNthFromEnd(newListNode(1, 2), 1);
        assertEquals("[1]", print(listNode));
    }
}
