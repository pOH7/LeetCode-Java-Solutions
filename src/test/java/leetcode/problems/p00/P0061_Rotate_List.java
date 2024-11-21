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
public class P0061_Rotate_List {
    @Test
    void test1() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2,3,4,5]");
        int k = 2;
        print(solution.rotateRight(head, k));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        ListNode head = ListNode.ofArrayString("[1,2]");
        int k = 1;
        print(solution.rotateRight(head, k));
    }

    interface Solution {
        public ListNode rotateRight(ListNode head, int k);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            int length = 1;
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
                length++;
            }

            // temp is at the end
            temp.next = head;

            k = length - k % length;
            while (k-- > 0) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
            return head;
        }
    }
}
