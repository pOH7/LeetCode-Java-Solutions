package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhanglei
 * @version 11/17/24
 */
@Medium
public class P0452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        assertEquals(2, solution.findMinArrowShots(points));
    }

    interface Solution {
        public int findMinArrowShots(int[][] points);
    }

    // 55 ms Beats 39.94%
    class Solution1 implements Solution {
        @Override
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
            int arrows = 1;
            int currentEnd = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > currentEnd) {
                    arrows++;
                    currentEnd = points[i][1];
                } else if (points[i][1] < currentEnd) {
                    currentEnd = points[i][1];
                }
            }
            return arrows;
        }
    }
}
