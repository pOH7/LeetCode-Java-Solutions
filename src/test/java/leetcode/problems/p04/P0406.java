package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 *
 * @link https://leetcode.com/problems/queue-reconstruction-by-height/
 * @reference
 *     https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89359/Explanation-of-the-neat-Sort%2BInsert-solution
 * @author zhanglei
 * @date 2022/5/14
 */
@Slf4j
class P0406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(
                people,
                (t1, t2) -> {
                    if (t1[0] - t2[0] == 0) {
                        return t1[1] - t2[1];
                    } else {
                        return t2[0] - t1[0];
                    }
                });

        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }

    @Test
    void test1() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        assertEquals(
                "[[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]",
                Arrays.deepToString(reconstructQueue(people)));
    }

    @Test
    void test2() {
        int[][] people = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        assertEquals(
                "[[4, 0], [5, 0], [2, 2], [3, 2], [1, 4], [6, 0]]",
                Arrays.deepToString(reconstructQueue(people)));
    }
}
