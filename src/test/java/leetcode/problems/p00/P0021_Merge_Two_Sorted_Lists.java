package leetcode.problems.p00;

import static leetcode.utils.LeetCodeUtils.ListNode;
import static leetcode.utils.LeetCodeUtils.print;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @title Merge Two Sorted Lists
 * @link https://leetcode.com/problems/merge-two-sorted-lists/
 * @author zhanglei
 * @date 2021/10/8
 */
class P0021_Merge_Two_Sorted_Lists {

    @Test
    void test1() {
        Solution solution = new Solution2();

        Random random = new Random();
        ListNode list1 =
                ListNode.generateRandomListNode(
                        random.nextInt(10), -100, 100, ListNode.Order.ASCENDING);
        print(list1);
        ListNode list2 =
                ListNode.generateRandomListNode(
                        random.nextInt(10), -100, 100, ListNode.Order.ASCENDING);
        print(list2);
        ListNode listNode = solution.mergeTwoLists(list1, list2);
        print(listNode);
    }

    interface Solution {
        ListNode mergeTwoLists(ListNode list1, ListNode list2);
    }

    class Solution1 implements Solution {
        /** time complexity: O(n) space complexity: O(1) n: l1.length + l2.length */
        @Override
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0, null);
            ListNode curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            if (l1 == null) {
                curr.next = l2;
            } else {
                curr.next = l1;
            }
            return dummy.next;
        }
    }

    class Solution2 implements Solution {

        @Override
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }
}
