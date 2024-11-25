package leetcode.problems.p09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Medium
public class P0904_Fruit_Into_Baskets {
    @Test
    void test1() {
        Solution solution = new Solution2();
        int[] fruits = {1, 2, 1};
        assertEquals(3, solution.totalFruit(fruits));
    }

    @Test
    void test3() {
        Solution solution = new Solution2();
        int[] fruits = {1, 2, 3, 2, 2};
        assertEquals(4, solution.totalFruit(fruits));
    }

    @Test
    void test14() {
        Solution solution = new Solution2();
        int[] fruits = {0, 1, 0, 2};
        assertEquals(3, solution.totalFruit(fruits));
    }

    @Test
    void test49() {
        Solution solution = new Solution2();
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        assertEquals(5, solution.totalFruit(fruits));
    }

    interface Solution {
        public int totalFruit(int[] fruits);
    }

    // 52 ms Beats 34.44%
    class Solution1 implements Solution {
        @Override
        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> baskets = new HashMap<>();
            int left = 0;
            int right = 0;
            int maxLength = 0;
            while (right < fruits.length) {
                if (baskets.size() == 2 && !baskets.containsKey(fruits[right])) {
                    while (baskets.size() == 2) {
                        Integer count = baskets.get(fruits[left]);
                        if (count > 1) {
                            baskets.put(fruits[left], count - 1);
                        } else {
                            baskets.remove(fruits[left]);
                        }
                        left++;
                    }
                }
                baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            return maxLength;
        }
    }

    // 42 ms Beats 83.60%
    class Solution2 implements Solution {
        @Override
        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> baskets = new HashMap<>();
            int left = 0;
            int right = 0;
            int maxLength = 0;
            while (right < fruits.length) {
                baskets.put(fruits[right], baskets.getOrDefault(fruits[right], 0) + 1);
                while (baskets.size() > 2) {
                    Integer count = baskets.get(fruits[left]);
                    if (count > 1) {
                        baskets.put(fruits[left], count - 1);
                    } else {
                        baskets.remove(fruits[left]);
                    }
                    left++;
                }

                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            return maxLength;
        }
    }
}
