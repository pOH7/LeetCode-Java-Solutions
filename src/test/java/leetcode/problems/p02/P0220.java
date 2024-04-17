package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglei
 * @version 2021/11/24
 * @link https://leetcode.com/problems/contains-duplicate-iii/
 */
public class P0220 {

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        // if two elements fill in same bucket, then it must be diff <= t (bucket.length = t + 1).
        Map<Long, Long> bucket = new HashMap<>();
        long bucketLength = (long) t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], bucketLength);
            if (bucket.containsKey(m)) return true;
            if (bucket.containsKey(m - 1) && Math.abs(nums[i] - bucket.get(m - 1)) < bucketLength)
                return true;
            if (bucket.containsKey(m + 1) && Math.abs(nums[i] - bucket.get(m + 1)) < bucketLength)
                return true;
            bucket.put(m, (long) nums[i]);
            if (i >= k) bucket.remove(getID(nums[i - k], bucketLength));
        }
        return false;
    }

    // Time Limit Exceeded
    //    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //        for (int i = 0, numsLength = nums.length; i < numsLength - 1; i++) {
    //            int num = nums[i];
    //            for (int j = i + 1; j <= i + k && j < numsLength; j++) {
    //                if (Math.abs((long) num - (long) nums[j]) <= t) {
    //                    return true;
    //                }
    //            }
    //        }
    //        return false;
    //    }

    @Test
    void test() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(containsNearbyAlmostDuplicate(nums, 3, 0));
    }

    @Test
    void test2() {
        int[] nums = {1, 0, 1, 1};
        assertTrue(containsNearbyAlmostDuplicate(nums, 1, 2));
    }

    @Test
    void test3() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        assertFalse(containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
