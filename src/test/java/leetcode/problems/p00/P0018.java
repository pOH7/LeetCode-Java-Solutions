package leetcode.problems.p00;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 18. 4Sum
 *
 * @link https://leetcode.com/problems/4sum/
 * @author zhanglei
 * @date 2022/2/24
 */
@Slf4j
class P0018 {

    // recursive solution
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        log.info("nums = {}", Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        fourSum(nums, target, 0, 4, new ArrayList<>(), result);
        return result;
    }

    void fourSum(
            int[] nums,
            int target,
            int start,
            int n,
            List<Integer> temp,
            List<List<Integer>> result) {
        if (n > nums.length) {
            return;
        }

        if (n == 2) {
            int low = start;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    List<Integer> r = new ArrayList<>(temp);
                    r.add(nums[low]);
                    r.add(nums[high]);
                    result.add(r);
                    while (nums[high] == nums[high - 1] && low < high) {
                        high--;
                    }
                    high--;
                    while (nums[low] == nums[low + 1] && low < high) {
                        low++;
                    }
                    low++;
                } else if (nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        } else {
            for (int i = start; i < nums.length - n + 1; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                List<Integer> t = new ArrayList<>(temp);
                t.add(nums[i]);
                fourSum(nums, target - nums[i], i + 1, n - 1, t, result);
            }
        }
    }

    /*
    // iterative solution
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        log.info("{}", Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = nums.length - 1; j >= 3; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int low = i + 1;
                int high = j - 1;

                while (low < high) {
                    if (nums[i] + nums[low] + nums[high] + nums[j] == target) {

                        result.add(Arrays.asList(nums[i], nums[low], nums[high], nums[j]));
                        while (nums[high] == nums[high - 1] && low < high) {
                            high--;
                        }
                        high--;
                        while (nums[low] == nums[low + 1] && low < high) {
                            low++;
                        }
                        low++;
                    } else if (nums[i] + nums[low] + nums[high] + nums[j] > target) {
                        while (nums[high] == nums[high - 1] && low < high) {
                            high--;
                        }
                        high--;
                    } else {
                        while (nums[low] == nums[low + 1] && low < high) {
                            low++;
                        }
                        low++;
                    }
                }
            }
        }
        return result;
    }
    */

    @Test
    void test1() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        assertEquals("[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]", fourSum(nums, 0).toString());
    }

    @Test
    void test2() {
        int[] nums = {2, 2, 2, 2, 2};
        assertEquals("[[2, 2, 2, 2]]", fourSum(nums, 8).toString());
    }

    @Test
    void test3() {
        int[] nums = {-3, -1, 0, 2, 4, 5};
        assertEquals("[[-3, -1, 0, 4]]", fourSum(nums, 0).toString());
    }
}
