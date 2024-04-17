package leetcode.problems.p00;

import leetcode.bean.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/reverse-linked-list-ii/
 * @author zhanglei
 * @date 2021/9/29
 */
public class P0092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;
        for (ListNode node = dummy; node != null; node = node.next) {
            if (node.val == left) {
                break;
            }
            if (node.next.val == left) {
                leftPrev = node;
                break;
            }
        }

        // insert into leftPrev leftPrev.next
        ListNode leftNode = leftPrev.next;
        ListNode rightTemp = leftNode.next;
        while (rightTemp != null && rightTemp.val <= right) {
            leftNode.next = rightTemp.next;
            rightTemp.next = leftPrev.next;
            leftPrev.next = rightTemp;
            rightTemp = leftNode.next;
        }
        //        leftNode.next = rightTemp;

        return dummy.next;
    }

    @Test
    void test() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        ListNode node = ListNode.newListNode(ints);
        ListNode listNode = reverseBetween(node, 2, 6);
        System.out.println();
    }

    @Test
    void test2() {
        int[] ints = {5};
        ListNode node = ListNode.newListNode(ints);
        ListNode listNode = reverseBetween(node, 5, 5);
        System.out.println();
    }

    @Test
    void test3() {
        int[] ints = {5, 6};
        ListNode node = ListNode.newListNode(ints);
        ListNode listNode = reverseBetween(node, 5, 6);
        System.out.println();
    }
}
