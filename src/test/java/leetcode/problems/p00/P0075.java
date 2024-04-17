package leetcode.problems.p00;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @link https://leetcode.com/problems/sort-colors/
 * @author zhanglei
 * @date 2021/11/3
 */
public class P0075 {
    /** time complexity: O(n) space complexity: O(1) */
    //    public void sortColors(int[] nums) {
    //        int[] temp = new int[]{0, 0, 0};
    //        for (int num : nums) {
    //            temp[num]++;
    //        }
    //        for (int i = 0; i < nums.length; i++) {
    //            if (i < temp[0]) {
    //                nums[i] = 0;
    //            } else if (i < temp[0] + temp[1]) {
    //                nums[i] = 1;
    //            } else {
    //                nums[i] = 2;
    //            }
    //        }
    //    }

    /** time complexity: O(n) space complexity: O(1) */
    public void sortColors(int[] nums) {
        int pos_0_end = 0;
        int pos_2_start = nums.length - 1;
        for (int i = 0; i <= pos_2_start; ) {
            if (nums[i] == 0) {
                nums[i] = nums[pos_0_end];
                nums[pos_0_end] = 0;
                pos_0_end++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                nums[i] = nums[pos_2_start];
                nums[pos_2_start] = 2;
                pos_2_start--;
            }
        }
    }

    @Test
    void test() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void test2() {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
