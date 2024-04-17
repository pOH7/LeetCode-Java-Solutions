package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 47. Permutations II
 *
 * @link https://leetcode.com/problems/permutations-ii/
 * @author zhanglei
 * @date 2022/4/20
 */
class P0047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(
                Arrays.stream(nums).sorted().boxed().collect(Collectors.toList()),
                new ArrayList<>(),
                result);
        return result;
    }

    void permuteUnique(List<Integer> nums, List<Integer> temp, List<List<Integer>> result) {
        if (nums.size() == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            Integer prev = null;
            for (int i = 0, len = nums.size(); i < len; i++) {
                if (nums.get(i).equals(prev)) {
                    continue;
                }
                prev = nums.remove(i);
                temp.add(prev);
                permuteUnique(nums, temp, result);
                nums.add(i, temp.remove(temp.size() - 1));
            }
        }
    }

    @Test
    void test1() {
        int[] nums = {1, 1, 2};
        assertEquals("[[1, 1, 2], [1, 2, 1], [2, 1, 1]]", permuteUnique(nums).toString());
    }

    @Test
    void test2() {
        int[] nums = {1, 2, 3};
        assertEquals(
                "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]",
                permuteUnique(nums).toString());
    }
}
