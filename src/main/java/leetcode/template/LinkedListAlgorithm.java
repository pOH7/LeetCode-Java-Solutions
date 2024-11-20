package leetcode.template;

import leetcode.utils.LeetCodeUtils.ListNode;

/**
 * @author zhanglei
 * @version 11/20/24
 */
public class LinkedListAlgorithm {
    public ListNode processLinkedList(ListNode head) {
        // Create a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers, prev and curr
        ListNode prev = dummy;
        ListNode curr = head;

        // Traverse the linked list
        while (curr != null) {
            // Perform some operation
            // Example: Remove nodes with a specific value
            if (curr.val == 0) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        // Return the new head of the linked list
        return dummy.next;
    }
}
