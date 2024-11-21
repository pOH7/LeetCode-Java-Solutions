package leetcode.template;

/**
 * @author zhanglei
 * @version 2024/11/21
 */
public class SlidingWindowTemplate {
    public int slidingWindow(int[] nums, int k) {
        // Initialize variables
        int left = 0, right = 0; // Window boundaries
        int currentSum = 0; // Tracks the sum or another condition in the window
        int result = 0; // Stores the final result (e.g., max value, count, etc.)

        // Expand the window by moving the 'right' pointer
        while (right < nums.length) {
            // Add the current element to the window
            currentSum += nums[right];

            // Shrink the window if it exceeds size `k` (or violates the problem's condition)
            while (right - left + 1 > k) {
                currentSum -= nums[left];
                left++; // Move the left boundary to shrink the window
            }

            // Optionally, update the result if the window meets the conditions
            if (right - left + 1 == k) {
                result = Math.max(result, currentSum);
            }

            // Move the right boundary to expand the window
            right++;
        }

        return result; // Return the result after processing all elements
    }
}
