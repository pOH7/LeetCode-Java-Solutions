package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * @link https://leetcode.com/problems/combinations/
 * @author zhanglei
 * @date 2022/3/24
 */
class P0077 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, new ArrayList<>(), result);
        return result;
    }

    // improved
    void combine(int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int size = temp.size(), start = size == 0 ? 1 : temp.get(size - 1) + 1, i = start;
                    i <= n - (k - size) + 1;
                    i++) {
                temp.add(i);
                combine(n, k, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    /*
    void combine(int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(temp);
        } else {
            for (int i = (temp.size() == 0 ? 1 : temp.get(temp.size() - 1) + 1); i <= n; i++) {
                List<Integer> temp2 = new ArrayList<>(temp);
                temp2.add(i);
                combine(n, k, temp2, result);
            }
        }
    }
    */

    @Test
    void test1() {
        assertEquals("[[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]", combine(4, 2).toString());
    }

    @Test
    void test2() {
        assertEquals("[[1]]", combine(1, 1).toString());
    }
}
