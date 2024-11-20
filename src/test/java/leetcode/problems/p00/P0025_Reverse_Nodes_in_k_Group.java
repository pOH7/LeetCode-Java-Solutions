package leetcode.problems.p00;

import static leetcode.utils.LeetCodeUtils.print;

import leetcode.difficulty.Hard;
import leetcode.utils.LeetCodeUtils.ListNode;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 11/20/24
 */
@Hard
public class P0025_Reverse_Nodes_in_k_Group {
    @Test
    void test1() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        print(solution.reverseKGroup(head, 2));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        print(solution.reverseKGroup(head, 3));
    }

    interface Solution {
        public ListNode reverseKGroup(ListNode head, int k);
    }

    // 1 ms Beats 37.78%
    class Solution1 implements Solution {
        @Override
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k <= 1) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            int total = 0;
            while (head != null) {
                head = head.next;
                total++;
            }
            int round = 1;
            ListNode prevGroupEnd = dummy;
            ListNode groupStart = dummy.next;
            while (round * k <= total) {
                ListNode current = groupStart;
                for (int i = 1; i < k; i++) {
                    ListNode next = current.next;
                    current.next = next.next;
                    next.next = prevGroupEnd.next;
                    prevGroupEnd.next = next;
                }
                prevGroupEnd = groupStart;
                groupStart = current.next;
                round++;
            }
            return dummy.next;
        }
    }
}
