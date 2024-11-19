package leetcode.template;

/**
 * Template for Kadane's Algorithm variations
 *
 * @author zhanglei
 * @version 2024/11/19
 */
public class KadaneTemplate {

    public static void main(String[] args) {
        KadaneTemplate kt = new KadaneTemplate();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Test basic maximum subarray sum
        System.out.println("Maximum subarray sum: " + kt.maxSubArray(nums));

        // Test with indices
        int[] result = kt.maxSubArrayWithIndices(nums);
        System.out.println(
                "Maximum sum: "
                        + result[0]
                        + ", Start index: "
                        + result[1]
                        + ", End index: "
                        + result[2]);

        // Test circular array
        int[] circularNums = {1, -2, 3, -2};
        System.out.println(
                "Maximum circular subarray sum: " + kt.maxSubArrayCircular(circularNums));

        // Test minimum subarray sum
        System.out.println("Minimum subarray sum: " + kt.minSubArray(nums));
    }

    // Basic Kadane's - returns maximum subarray sum
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Kadane's with subarray indices
    public int[] maxSubArrayWithIndices(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {0, -1, -1};

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxEndingHere + nums[i]) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere = maxEndingHere + nums[i];
            }

            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }

        return new int[] {maxSoFar, start, end};
    }

    // Kadane's for circular array
    public int maxSubArrayCircular(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // Case 1: get the maximum sum using standard Kadane's
        int maxNormal = maxSubArray(nums);

        // If all numbers are negative, return the maximum normal sum
        if (maxNormal < 0) return maxNormal;

        // Case 2: find the maximum sum that includes circular connection
        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
            nums[i] = -nums[i]; // Invert the array
        }

        int maxCircular = arraySum + maxSubArray(nums); // Using inverted array

        return Math.max(maxNormal, maxCircular);
    }

    // Minimum subarray sum using Kadane's
    public int minSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int minSoFar = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            minEndingHere = Math.min(nums[i], minEndingHere + nums[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }
}
