package leetcode.problems.p08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/25
 */
@Medium
public class P0852_Peak_Index_in_a_Mountain_Array {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] arr = {0, 1, 0};
        assertEquals(1, solution.peakIndexInMountainArray(arr));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int[] arr = {3, 4, 5, 1};
        assertEquals(2, solution.peakIndexInMountainArray(arr));
    }

    interface Solution {
        public int peakIndexInMountainArray(int[] arr);
    }

    // 0 ms Beats 100.00%
    class Solution1 implements Solution {
        @Override
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (arr[mid] < arr[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
