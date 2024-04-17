package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.ListNode;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

/**
 * 203. Remove Linked List Elements
 *
 * @link https://leetcode.com/problems/remove-linked-list-elements/
 * @author zhanglei
 * @date 2022/2/23
 */
@Slf4j
public class P0203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode next = dummy;
        while (next.next != null) {
            if (next.next.val == val) {
                ListNode t = next.next;
                next.next = t.next;
                t.next = null;
            } else {
                next = next.next;
            }
            log.info(ListNode.print(dummy));
        }
        return dummy.next;
    }

    @Test
    void test1() {
        assertEquals(
                "[1,2,3,4,5]",
                ListNode.print(removeElements(ListNode.newListNode(1, 2, 6, 3, 4, 5, 6), 6)));
    }

    @Test
    void test2() {
        assertEquals("[]", ListNode.print(removeElements(ListNode.newListNode(), 1)));
    }

    @Test
    void test3() {
        assertEquals("[]", ListNode.print(removeElements(ListNode.newListNode(7, 7, 7, 7), 7)));
    }
}
