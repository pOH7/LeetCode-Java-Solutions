package leetcode.problems.p04;

import leetcode.exception.NoSolutionException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 *
 * @link https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * @author zhanglei
 * @date 2022/5/14
 */
class P0452 {
    public int findMinArrowShots(int[][] points) {
        throw new NoSolutionException();
    }

    @Test
    void test1() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Assertions.assertEquals(2, findMinArrowShots(points));
    }

    @Test
    void test2() {
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        Assertions.assertEquals(4, findMinArrowShots(points));
    }

    @Test
    void test3() {
        int[][] points = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        Assertions.assertEquals(2, findMinArrowShots(points));
    }
}
