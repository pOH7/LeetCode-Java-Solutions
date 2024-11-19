package leetcode.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglei
 * @version 2024/11/19
 */
public class GreedyTemplate {

    // Example usage
    public static void main(String[] args) {
        GreedyTemplate gt = new GreedyTemplate();

        // Test interval scheduling
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(
                "Max non-overlapping intervals: " + gt.maxNonOverlappingIntervals(intervals));

        // Test meeting rooms
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Minimum meeting rooms required: " + gt.minMeetingRooms(meetings));

        // Test fractional knapsack
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        System.out.println(
                "Maximum value in knapsack: " + gt.fractionalKnapsack(values, weights, 50));
    }

    // Interval Scheduling Pattern
    public int maxNonOverlappingIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return count;
    }

    // Activity Selection Pattern
    public List<int[]> selectActivities(int[][] activities) {
        // Sort by end time
        Arrays.sort(activities, (a, b) -> a[1] - b[1]);

        List<int[]> selected = new ArrayList<>();
        selected.add(activities[0]);

        int lastEnd = activities[0][1];

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= lastEnd) {
                selected.add(activities[i]);
                lastEnd = activities[i][1];
            }
        }
        return selected;
    }

    // Fractional Knapsack Pattern
    public double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        double[][] ratio = new double[n][2];

        // Calculate value/weight ratio
        for (int i = 0; i < n; i++) {
            ratio[i] = new double[] {(double) values[i] / weights[i], i};
        }

        // Sort by ratio in descending order
        Arrays.sort(ratio, (a, b) -> Double.compare(b[0], a[0]));

        double totalValue = 0;
        int currentWeight = 0;

        for (double[] item : ratio) {
            int idx = (int) item[1];
            if (currentWeight + weights[idx] <= capacity) {
                currentWeight += weights[idx];
                totalValue += values[idx];
            } else {
                double remaining = capacity - currentWeight;
                totalValue += values[idx] * (remaining / weights[idx]);
                break;
            }
        }
        return totalValue;
    }

    // Meeting Rooms Pattern
    public int minMeetingRooms(int[][] meetings) {
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int maxRooms = 0;
        int s = 0, e = 0;

        while (s < n) {
            if (start[s] < end[e]) {
                rooms++;
                s++;
            } else {
                rooms--;
                e++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }
}
