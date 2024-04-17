package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @link https://leetcode.com/problems/n-queens/
 * @author zhanglei
 * @date 2022/4/24
 */
class P0051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, new ArrayList<>(), result);
        return result;
    }

    void solveNQueens(int n, List<Integer> temp, List<List<String>> result) {
        if (temp.size() == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == temp.get(i)) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
        }
        for (int i = 0; i < n; i++) {
            Integer num = i;
            boolean valid = true;
            if (temp.contains(num)) {
                continue;
            }
            for (int j = 0; j < temp.size(); j++) {
                if (!valid(n, temp.get(j), temp.size() - j, num)) {
                    valid = false;
                    break;
                }
            }
            if (!valid) {
                continue;
            }
            temp.add(num);
            solveNQueens(n, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    boolean valid(int n, int pos, int level, int num) {
        return !(pos - level >= 0 && pos - level == num || pos + level < n && pos + level == num);
    }

    @Test
    void test1() {
        assertEquals(
                "[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]", solveNQueens(4).toString());
    }

    @Test
    void test2() {
        assertEquals("[[Q]]", solveNQueens(1).toString());
    }
}
