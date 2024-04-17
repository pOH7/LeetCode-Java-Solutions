package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. Increasing Subsequences
 *
 * @link https://leetcode.com/problems/increasing-subsequences/
 * @author zhanglei
 * @date 2022/4/19
 */
class P0491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void findSubsequences(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() > 1) {
            result.add(new ArrayList<>(temp));
        }
        Set<Integer> prev = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (temp.size() > 0 && i > 0 && nums[i] < temp.get(temp.size() - 1)
                    || i != index && prev.contains(nums[i])) {
                continue;
            }
            int num = nums[i];
            prev.add(num);
            temp.add(num);
            findSubsequences(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    void test1() {
        int[] nums = {4, 6, 7, 7};
        assertEquals(
                "[[4, 6], [4, 6, 7], [4, 6, 7, 7], [4, 7], [4, 7, 7], [6, 7], [6, 7, 7], [7, 7]]",
                findSubsequences(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {4, 4, 3, 2, 1};
        assertEquals("[[4, 4]]", findSubsequences(nums).toString());
    }
}
