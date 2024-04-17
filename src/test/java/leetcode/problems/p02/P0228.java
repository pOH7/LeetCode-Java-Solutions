package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.com/problems/summary-ranges/
 * @author zhanglei
 * @date 2021/12/2
 */
public class P0228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        Integer i = null, j = null, iIndex = null, jIndex = null;
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (i == null) {
                i = num;
                iIndex = index;
                j = num;
                jIndex = index;
            } else {
                if (num - i == jIndex + 1 - iIndex) {
                    j = num;
                    jIndex = index;
                } else {
                    if (i.equals(j)) {
                        result.add(i + "");
                    } else {
                        result.add(i + "->" + j);
                    }
                    i = num;
                    iIndex = index;
                    j = num;
                    jIndex = index;
                }
            }
        }
        if (i != null && !i.equals(j)) {
            result.add(i + "->" + j);
        } else if (i != null && i.equals(j)) {
            result.add(i + "");
        }
        return result;
    }

    @Test
    void test() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        assertEquals("[0->2, 4->5, 7]", Arrays.toString(summaryRanges(nums).toArray()));
    }
}
