package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0283_Move_Zeroes {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        assertEquals("[1,3,12,0,0]", Arrays.toString(nums).replace(" ", ""));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] nums = {0};
        solution.moveZeroes(nums);
        assertEquals("[0]", Arrays.toString(nums).replace(" ", ""));
    }

    interface Solution {
        public void moveZeroes(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public void moveZeroes(int[] nums) {
            int j = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (j < 0) {
                        j = i + 1;
                    }
                    for (; j < nums.length; j++) {
                        if (nums[j] != 0) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                    if (j >= nums.length) {
                        break;
                    }
                }
            }
        }
    }
}
