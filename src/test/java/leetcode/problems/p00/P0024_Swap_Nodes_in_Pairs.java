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
public class P0024_Swap_Nodes_in_Pairs {
    @Test
    void test1() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        print(solution.swapPairs(head));
    }

    interface Solution {
        public ListNode swapPairs(ListNode head);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode prev = dummy;
            while (head != null && head.next != null) {
                ListNode next = head.next;
                prev.next = next;
                head.next = next.next;
                next.next = head;
                prev = head;
                head = head.next;
            }
            return dummy.next;
        }
    }
}
