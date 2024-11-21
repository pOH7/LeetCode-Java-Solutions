package leetcode.problems.p03;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Medium;
import leetcode.utils.LeetCodeUtils.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/20
 */
@Medium
public class P0328_Odd_Even_Linked_List {
    @Test
    void test1() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        print(solution.oddEvenList(head));
    }

    interface Solution {
        public ListNode oddEvenList(ListNode head);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode prev = even;
            ListNode current = even.next;
            int index = 3;
            while (current != null) {
                if ((index & 1) == 1) {
                    odd.next = current;
                    ListNode next = current.next;
                    prev.next = next;
                    current.next = even;
                    odd = current;
                    current = next;
                } else {
                    prev = current;
                    current = current.next;
                }
                index++;
            }
            return head;
        }
    }
}
