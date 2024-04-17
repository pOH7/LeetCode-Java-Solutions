package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * @link https://leetcode.com/problems/subsets-ii/
 * @author zhanglei
 * @date 2022/4/19
 */
class P0090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(nums, 0, new ArrayList<>(), result);
        return result;
    }

    void subsetsWithDup(int[] nums, int index, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            temp.add(num);
            subsetsWithDup(nums, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 2};
        assertEquals("[[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]", subsetsWithDup(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {0};
        assertEquals("[[], [0]]", subsetsWithDup(nums).toString());
    }
}
