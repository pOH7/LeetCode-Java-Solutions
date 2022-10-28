package leetcode.problems.p00;

import leetcode.bean.ListNode;
import org.junit.jupiter.api.Test;

/**
 * @link https://leetcode.com/problems/merge-two-sorted-lists/
 * @author zhanglei
 * @date 2021/10/8
 */
public class P0021 {

    /** time complexity: O(n) space complexity: O(1) n: l1.length + l2.length */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0, null);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        return dummy.next;
    }

    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //        if(l1==null){
    //            return l2;
    //        }
    //        if(l2==null){
    //            return l1;
    //        }
    //        if(l1.val<l2.val){
    //            l1.next=mergeTwoLists(l1.next, l2);
    //            return l1;
    //        }else {
    //            l2.next = mergeTwoLists(l1,l2.next);
    //            return l2;
    //        }
    //    }

    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //        ListNode l = new ListNode(0, null);
    //        mergeTwoLists(l, l1, l2);
    //        return l.next;
    //    }
    //
    //    void mergeTwoLists(ListNode l, ListNode l1, ListNode l2) {
    //        if(l1==null&&l2==null){
    //            return;
    //        }else if(l1==null){
    //            mergeTwoLists(l,l2,l1);
    //        }else if(l2==null) {
    //            l.next = l1;
    //            mergeTwoLists(l1, l1.next,l2);
    //        }else if(l1.val<=l2.val) {
    //            l.next = l1;
    //            mergeTwoLists(l1, l1.next,l2);
    //        }else {
    //            mergeTwoLists(l, l2, l1);
    //        }
    //    }

    @Test
    void test1() {
        int[] l1 = {1, 2, 4};
        int[] l2 = {1, 3, 4};
        ListNode listNode = mergeTwoLists(ListNode.newListNode(l1), ListNode.newListNode(l2));
        String print = ListNode.print(listNode);
        System.out.println();
    }

    @Test
    void test2() {
        int[] l1 = {};
        int[] l2 = {};
        ListNode listNode = mergeTwoLists(ListNode.newListNode(l1), ListNode.newListNode(l2));
        System.out.println();
    }

    @Test
    void test3() {
        int[] l1 = {};
        int[] l2 = {0};
        ListNode listNode = mergeTwoLists(ListNode.newListNode(l1), ListNode.newListNode(l2));
        System.out.println();
    }
}
