package leetcode.bean;

/**
 * Definition for singly-linked list.
 *
 * @author zhanglei
 * @date 2021/10/8
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode newListNode(int... ints) {
        ListNode head = null;
        ListNode last = null;
        for (int i : ints) {
            if (head == null) {
                last = new ListNode(i);
                head = last;
            } else {
                last.next = new ListNode(i);
                last = last.next;
            }
        }
        return head;
    }

    public static String print(ListNode listNode) {
        StringBuilder sb = new StringBuilder("[");
        while (listNode != null) {
            sb.append(listNode.val);
            if (listNode.next != null) {
                sb.append(",");
            }
            listNode = listNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
