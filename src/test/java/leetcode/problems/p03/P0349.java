package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 349. Intersection of Two Arrays
 *
 * @link https://leetcode.com/problems/intersection-of-two-arrays/
 * @author zhanglei
 * @date 2022/2/23
 */
class P0349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums1).distinct().filter(set::contains).toArray();
    }

    /*
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(i -> (int) i).toArray();
    }
    */

    @Test
    void test1() {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        assertEquals("[2]", Arrays.toString(intersection(nums1, nums2)));
    }

    @Test
    void test2() {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        assertEquals(
                "[4, 9]",
                Arrays.toString(Arrays.stream(intersection(nums1, nums2)).sorted().toArray()));
    }
}
