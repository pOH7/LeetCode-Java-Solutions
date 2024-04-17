package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 *
 * @link https://leetcode.com/problems/4sum-ii/
 * @author zhanglei
 * @date 2022/2/24
 */
class P0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                count += map.getOrDefault(-nums3[i] - nums4[j], 0);
            }
        }
        return count;
    }

    @Test
    void test1() {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        assertEquals(2, fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    void test2() {
        int[] nums1 = {0};
        int[] nums2 = {0};
        int[] nums3 = {0};
        int[] nums4 = {0};
        assertEquals(1, fourSumCount(nums1, nums2, nums3, nums4));
    }
}
