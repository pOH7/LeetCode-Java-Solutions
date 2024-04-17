package leetcode.problems.p01;

import static leetcode.bean.ListNode.newListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.bean.ListNode;

import org.junit.jupiter.api.Test;

/**
 * 160. Intersection of Two Linked Lists
 *
 * @link https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author zhanglei
 * @date 2022/2/23
 */
class P0160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }

    /*
    // not good
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        Set<ListNode> cache = new HashSet<>();
        while (cur != null) {
            cache.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (cache.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    */

    @Test
    void test1() {
        ListNode listNode = newListNode(8, 4, 5);
        assertEquals(
                listNode,
                getIntersectionNode(
                        new ListNode(4, new ListNode(1, listNode)),
                        new ListNode(5, new ListNode(6, new ListNode(1, listNode)))));
    }

    @Test
    void test2() {
        ListNode listNode = newListNode(2, 4);
        assertEquals(
                listNode,
                getIntersectionNode(
                        new ListNode(1, new ListNode(9, new ListNode(1, listNode))),
                        new ListNode(3, listNode)));
    }

    @Test
    void test3() {
        assertEquals(null, getIntersectionNode(newListNode(2, 6, 4), newListNode(1, 5)));
    }
}
