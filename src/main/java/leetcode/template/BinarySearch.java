package leetcode.template;

/**
 * Binary Search Template in Java
 *
 * @author zhanglei
 * @version 2024/11/22
 */
public class BinarySearch {

    /**
     * Generic binary search method.
     *
     * @param arr Sorted array of integers
     * @param target The value to search for
     * @return The index of the target if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) return -1;

        int left = 0, right = arr.length - 1;

        while (left <= right) { // Ensures search space is valid
            int mid = (left + right) >>> 1; // Prevents overflow
            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                // maxBelow = mid;
                left = mid + 1; // Search right half
            } else {
                // minAbove = mid;
                right = mid - 1; // Search left half
            }
        }
        return -1; // Target not found
    }

    // Overload method for a recursive binary search
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1; // Base case: target not found

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right); // Search right
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1); // Search left
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        // Iterative approach
        int resultIterative = binarySearch(sortedArray, target);
        System.out.println("Iterative: Target found at index: " + resultIterative);

        // Recursive approach
        int resultRecursive = binarySearchRecursive(sortedArray, target);
        System.out.println("Recursive: Target found at index: " + resultRecursive);
    }
}
