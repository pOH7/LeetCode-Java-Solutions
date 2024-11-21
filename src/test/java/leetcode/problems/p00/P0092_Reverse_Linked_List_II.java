package leetcode.problems.p00;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
@Medium
public class P0092_Reverse_Linked_List_II {
    @Test
    void test1() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        int left = 2, right = 4;
        print(solution.reverseBetween(head, left, right));
    }

    interface Solution {
        public ListNode reverseBetween(ListNode head, int left, int right);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            int index = 1;
            while (head != null && index < left) {
                prev = head;
                head = head.next;
                index++;
            }

            // insert next after prev
            while (head != null && head.next != null && index < right) {
                ListNode next = head.next;
                head.next = next.next;
                next.next = prev.next;
                prev.next = next;
                index++;
            }
            return dummy.next;
        }
    }
}
