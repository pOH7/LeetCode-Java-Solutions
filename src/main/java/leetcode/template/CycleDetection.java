package leetcode.template;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
public class CycleDetection {
    // Method to detect if a cycle exists and return its starting node
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        // Phase 1: Detect cycle using Floyd's algorithm
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) return null;

        // Phase 2: Find cycle start
        // Reset slow to head, keep fast at meeting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // Return start of cycle
    }

    // Helper method that just checks cycle existence
    public static boolean hasCycle(ListNode head) {
        return detectCycle(head) != null;
    }

    public static int findCycleLength(ListNode head) {
        ListNode cycleStart = detectCycle(head);
        if (cycleStart == null) return 0;

        int length = 1;
        ListNode current = cycleStart.next;
        while (current != cycleStart) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static void main(String[] args) {
        // Test case with cycle
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create cycle at node 2

        ListNode cycleStart = detectCycle(head);
        System.out.println("Has cycle: " + (cycleStart != null));
        System.out.println("Cycle start value: " + (cycleStart != null ? cycleStart.val : "N/A"));
        System.out.println("Cycle length: " + findCycleLength(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }
}
