package leetcode.problems.p00;

import leetcode.bean.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.bean.ListNode.newListNode;
import static leetcode.bean.ListNode.print;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 24. Swap Nodes in Pairs
 *
 * @link https://leetcode.com/problems/swap-nodes-in-pairs/
 * @author zhanglei
 * @date 2022/2/23
 */
class P0024 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode n1 = cur.next;
            ListNode n2 = n1.next;
            n1.next = n2.next;
            cur.next = n2;
            n2.next = n1;
            cur = n1;
        }
        return dummy.next;
    }

    @Test
    void test1() {
        assertEquals("[2,1,4,3]", print(swapPairs(newListNode(1, 2, 3, 4))));
    }

    @Test
    void test2() {
        assertEquals("[]", print(swapPairs(newListNode())));
    }

    @Test
    void test3() {
        assertEquals("[1]", print(swapPairs(newListNode(1))));
    }
}
