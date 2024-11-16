package leetcode.problems.p04;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 11/16/24
 */
@Medium
public class P0494_Target_Sum {
    @Test
    void test1() {
        Solution solution = new Solution2();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target));
    }

    interface Solution {
        public int findTargetSumWays(int[] nums, int target);
    }

    // 604 ms Beats 27.67%
    class Solution1 implements Solution {
        @Override
        public int findTargetSumWays(int[] nums, int target) {
            return backtracking(nums, target, 0);
        }

        int backtracking(int[] nums, int target, int idx) {
            if (idx == nums.length) {
                if (target == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return backtracking(nums, target - nums[idx], idx + 1)
                    + backtracking(nums, target + nums[idx], idx + 1);
        }
    }

    // 234 ms Beats 36.16%
    class Solution2 implements Solution {
        @Override
        public int findTargetSumWays(int[] nums, int target) {
            int[] sums = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i == nums.length - 1) {
                    sums[i] = nums[i];
                } else {
                    sums[i] = sums[i + 1] + nums[i];
                }
            }
            return backtracking(nums, target, 0, sums);
        }

        int backtracking(int[] nums, int target, int idx, int[] sums) {
            if (idx == nums.length) {
                if (target == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (Math.abs(target) > sums[idx]) {
                return 0;
            }
            return backtracking(nums, target - nums[idx], idx + 1, sums)
                    + backtracking(nums, target + nums[idx], idx + 1, sums);
        }
    }
}
