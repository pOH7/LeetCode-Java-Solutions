package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * @link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author zhanglei
 * @date 2022/4/26
 */
class P0122 {
    // greedy algorithm
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    @Test
    void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(7, maxProfit(prices));
    }

    @Test
    void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, maxProfit(prices));
    }

    @Test
    void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, maxProfit(prices));
    }
}
