package leetcode.problems.p00;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 15. 3Sum
 *
 * @link https://leetcode.com/problems/3sum/
 * @author zhanglei
 * @date 2022/2/24
 */
@Slf4j
class P0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (nums[low++] == nums[low] && low < high) {}
                    while (nums[high--] == nums[high] && low < high) {}
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    while (nums[low++] == nums[low] && low < high) {}
                } else {
                    while (nums[high--] == nums[high] && low < high) {}
                }
            }
        }
        return result;
    }

    @Test
    void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        assertEquals("[[-1, -1, 2], [-1, 0, 1]]", threeSum(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {};
        assertEquals("[]", threeSum(nums).toString());
    }

    @Test
    void test3() {
        int[] nums = {0};
        assertEquals("[]", threeSum(nums).toString());
    }

    @Test
    void test4() {
        int[] nums = {-2, 0, 1, 1, 2};
        assertEquals("[[-2, 0, 2], [-2, 1, 1]]", threeSum(nums).toString());
    }

    @Test
    void test5() {
        int[] nums = {0, 0, 0, 0, 0};
        assertEquals("[[0, 0, 0]]", threeSum(nums).toString());
    }

    @Test
    void test6() {
        int[] nums = {-2, 0, 0, 2, 2};
        assertEquals("[[-2, 0, 2]]", threeSum(nums).toString());
    }
}
