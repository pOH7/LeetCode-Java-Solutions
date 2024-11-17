package leetcode.problems.p06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhanglei
 * @version 11/17/24
 */
@Hard
public class P0630_Course_Schedule_III {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        assertEquals(3, solution.scheduleCourse(courses));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[][] courses = {{1, 2}};
        assertEquals(1, solution.scheduleCourse(courses));
    }

    @Test
    void test3() {
        Solution solution = new Solution1();
        int[][] courses = {{3, 2}, {4, 3}};
        assertEquals(0, solution.scheduleCourse(courses));
    }

    @Test
    void test80() {
        Solution solution = new Solution1();
        int[][] courses = {{7, 17}, {3, 12}, {10, 20}, {9, 10}, {5, 20}, {10, 19}, {4, 18}};
        assertEquals(4, solution.scheduleCourse(courses));
    }

    interface Solution {
        public int scheduleCourse(int[][] courses);
    }

    // 34 ms Beats 61.07%
    class Solution1 implements Solution {
        @Override
        public int scheduleCourse(int[][] courses) {
            Arrays.sort(courses, Comparator.comparingInt(c -> c[1]));
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            int total = 0;
            for (int[] course : courses) {
                // oops, exceeds the lastDay
                if (course[0] + total > course[1]) {
                    // replace the previous longest course if this one costs less time,
                    if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                        total -= maxHeap.poll();
                        maxHeap.offer(course[0]);
                        total += course[0];
                    }
                } else {
                    maxHeap.offer(course[0]);
                    total += course[0];
                }
            }
            return maxHeap.size();
        }
    }
}
