package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 46. Permutations
 *
 * @link https://leetcode.com/problems/permutations
 * @author zhanglei
 * @date 2022/4/20
 */
class P0046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(
                Arrays.stream(nums).boxed().collect(Collectors.toList()),
                new ArrayList<>(),
                result);
        return result;
    }

    void permute(List<Integer> nums, List<Integer> temp, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = 0, len = nums.size(); i < len; i++) {
                temp.add(nums.remove(i));
                permute(nums, temp, result);
                nums.add(i, temp.remove(temp.size() - 1));
            }
        }
    }

    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        assertEquals(
                "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]",
                permute(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {0, 1};
        assertEquals("[[0, 1], [1, 0]]", permute(nums).toString());
    }

    @Test
    void test3() {
        int[] nums = {1};
        assertEquals("[[1]]", permute(nums).toString());
    }
}
