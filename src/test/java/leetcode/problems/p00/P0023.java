package leetcode.problems.p00;

import leetcode.bean.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.bean.ListNode.newListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @link https://leetcode.com/problems/merge-k-sorted-lists/
 * @author zhanglei
 * @date 2021/10/8
 */
public class P0023 {
    /** time complexity: O(log(k) * n) space complexity: O(log(k)) n: sum(list.length) */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    ListNode mergeKLists(ListNode[] lists, int t1, int t2) {
        if (t1 == t2) {
            return lists[t1];
        } else if (t1 < t2) {
            int t = (t1 + t2) >>> 1;
            return merge2Lists(mergeKLists(lists, t1, t), mergeKLists(lists, t + 1, t2));
        } else {
            return null;
        }
    }

    ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }

    @Test
    void test1() {
        ListNode listNode =
                mergeKLists(
                        new ListNode[] {
                            newListNode(1, 4, 5), newListNode(1, 3, 4), newListNode(2, 6)
                        });
        assertEquals("[1,1,2,3,4,4,5,6]", ListNode.print(listNode));
    }
}
