package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 *
 * @link https://leetcode.com/problems/top-k-frequent-elements/
 * @author zhanglei
 * @date 2022/3/3
 */
class P0347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(k, Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() != k || queue.peek().getValue() < entry.getValue()) {
                if (queue.size() == k) {
                    queue.poll();
                }
                queue.offer(entry);
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    @Test
    void test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        assertEquals("[1, 2]", Arrays.toString(topKFrequent(nums, 2)));
    }

    @Test
    void test2() {
        int[] nums = {1};
        assertEquals("[1]", Arrays.toString(topKFrequent(nums, 1)));
    }
}
