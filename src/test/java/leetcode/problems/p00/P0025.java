package leetcode.problems.p00;

import leetcode.bean.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.bean.ListNode.newListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author zhanglei
 * @date 2021/12/2
 */
public class P0025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }

        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }
        return head;
    }

    @Test
    void test() {
        assertEquals("[2,1,4,3,5]", ListNode.print(reverseKGroup(newListNode(1, 2, 3, 4, 5), 2)));
    }
}
