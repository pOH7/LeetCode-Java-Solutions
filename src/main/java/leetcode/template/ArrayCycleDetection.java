package leetcode.template;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
public class ArrayCycleDetection {

    /**
     * Method to detect if a cycle exists and return its starting node
     *
     * @param arr index of the array is the node, value of the array is the next node
     * @return the start index of the cycle
     */
    public static int findCycleStart(int[] arr) {
        // Validate input
        if (arr == null || arr.length < 2) return -1;

        // Phase 1: Find meeting point using Floyd's algorithm
        int slow = 0;
        int fast = 0;

        do {
            // Check bounds for slow pointer
            if (slow >= arr.length || slow < 0) return -1;
            slow = arr[slow];

            // Check bounds for fast pointer (2 steps)
            if (fast >= arr.length || fast < 0) return -1;
            fast = arr[fast];
            if (fast >= arr.length || fast < 0) return -1;
            fast = arr[fast];

            // No cycle found if pointers reach invalid positions
            if (slow == -1 || fast == -1) return -1;

        } while (slow != fast);

        // Phase 2: Find cycle start
        slow = 0; // Reset slow to start
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }

    // Helper method for cycle detection
    public static boolean hasCycle(int[] arr) {
        return findCycleStart(arr) != -1;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2}; // Has cycle
        System.out.println("Cycle start index: " + findCycleStart(arr1));

        int[] arr2 = {1, 2, 3, 4}; // No cycle
        System.out.println("Cycle start index: " + findCycleStart(arr2));
    }
}
