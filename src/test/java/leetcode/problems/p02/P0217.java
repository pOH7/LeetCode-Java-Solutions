package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhanglei
 * @version 2021/11/24
 * @link https://leetcode.com/problems/contains-duplicate/
 */
public class P0217 {

    public boolean containsDuplicate(int[] nums) {
        return !Arrays.stream(nums).allMatch(new HashSet<>()::add);
    }

    //    public boolean containsDuplicate(int[] nums) {
    //        Set<Integer> set = new HashSet<>();
    //        for (int num : nums) {
    //            if (!set.add(num)) {
    //                return true;
    //            }
    //        }
    //        return false;
    //    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        assertTrue(containsDuplicate(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 4};
        assertFalse(containsDuplicate(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertTrue(containsDuplicate(nums));
    }
}
