package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 *
 * @link https://leetcode.com/problems/sliding-window-maximum/
 * @author zhanglei
 * @date 2022/3/2
 */
class P0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new ArrayDeque<>(k);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                addToWindow(window, nums[i]);
                continue;
            }
            addToWindow(window, nums[i]);
            result[i - k + 1] = window.peekFirst();
            if (i >= k - 1) {
                removeWindow(window, nums[i - k + 1]);
            }
        }
        return result;
    }

    static void addToWindow(Deque<Integer> window, int num) {
        while (!window.isEmpty() && window.peekLast() < num) {
            window.pollLast();
        }
        window.offer(num);
    }

    static void removeWindow(Deque<Integer> window, int num) {
        if (!window.isEmpty() && window.peekFirst() == num) {
            window.pollFirst();
        }
    }

    /*
    // Time Limit Exceeded
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] window = new int[k];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                window[i] = nums[i];
                if (i == k - 1) {
                    Arrays.sort(window);
                    result[i - k + 1] = window[k - 1];
                }
                continue;
            }
            adjust(window, nums[i - k], nums[i]);
            result[i - k + 1] = window[k - 1];
        }
        return result;
    }

    static void adjust(int[] window, int del, int add) {
        for (int i = 0, j = window.length - 1; i <= j; ) {
            int mid = i + j >>> 1;
            if (window[mid] == del) {
                window[mid] = add;
                Arrays.sort(window);
                return;
            } else if (window[mid] > del) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
    }
    */

    @Test
    void test1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        assertEquals("[3, 3, 5, 5, 6, 7]", Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    @Test
    void test2() {
        int[] nums = {1};
        assertEquals("[1]", Arrays.toString(maxSlidingWindow(nums, 1)));
    }

    @Test
    void test28() {
        int[] nums = {7, 2, 4};
        assertEquals("[7, 4]", Arrays.toString(maxSlidingWindow(nums, 2)));
    }

    @Test
    void test29() {
        int[] nums = {1, 3, 1, 2, 0, 5};
        assertEquals("[3, 3, 2, 5]", Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
