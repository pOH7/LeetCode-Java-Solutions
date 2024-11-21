package leetcode.problems.p02;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Easy;
import leetcode.utils.LeetCodeUtils.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
@Easy
public class P0206_Reverse_Linked_List {
    @Test
    void test1() {
        Solution solution = new Solution2();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        print(solution.reverseList(head));
    }

    interface Solution {
        public ListNode reverseList(ListNode head);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            while (current != null) {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    }

    // 0 ms Beats 100.00%
    class Solution2 implements Solution {
        @Override
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode next = head.next;
            while (next != null) {
                head.next = next.next;
                next.next = dummy.next;
                dummy.next = next;
                next = head.next;
            }
            return dummy.next;
        }
    }
}
