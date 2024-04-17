package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * @link https://leetcode.com/problems/subsets/
 * @author zhanglei
 * @date 2022/4/14
 */
class P0078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void subsets(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            subsets(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        assertEquals(
                "[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]", subsets(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {0};
        assertEquals("[[], [0]]", subsets(nums).toString());
    }
}
