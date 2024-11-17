package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import leetcode.difficulty.Easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
@Easy
public class P0121_Best_Time_to_Buy_and_Sell_Stock {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    interface Solution {
        public int maxProfit(int[] prices);
    }

    // 2 ms Beats 77.49%
    class Solution1 implements Solution {

        @Override
        public int maxProfit(int[] prices) {
            int buy = prices[0];
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < buy) {
                    buy = prices[i];
                } else if (prices[i] - buy > profit) {
                    profit = prices[i] - buy;
                }
            }
            return profit;
        }
    }
}
