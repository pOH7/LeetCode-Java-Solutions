package leetcode.problems.p08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.com/problems/positions-of-large-groups/
 * @author zhanglei
 * @date 2021/12/8
 */
public class P0830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char pre = 0;
        int start = -1;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (start == -1) {
                start = i;
                pre = s.charAt(i);
                continue;
            }
            if (pre != s.charAt(i)) {
                if (i - 1 - start + 1 >= 3) {
                    result.add(Arrays.asList(start, i - 1));
                }
                start = i;
                pre = s.charAt(i);
            }
        }
        if (s.length() - 1 - start + 1 >= 3) {
            result.add(Arrays.asList(start, s.length() - 1));
        }
        return result;
    }

    @Test
    void test() {
        assertEquals("[[3, 6]]", largeGroupPositions("abbxxxxzzy").toString());
    }

    @Test
    void test2() {
        assertEquals("[[0, 2]]", largeGroupPositions("aaa").toString());
    }
}
