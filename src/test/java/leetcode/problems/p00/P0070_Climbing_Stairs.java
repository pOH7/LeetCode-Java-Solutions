package leetcode.problems.p00;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0070_Climbing_Stairs {

    @Test
    void test1() {
        Solution solution = new Solution1();
        assertEquals(2, solution.climbStairs(2));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        assertEquals(3, solution.climbStairs(3));
    }

    interface Solution {
        public int climbStairs(int n);
    }

    class Solution1 implements Solution {

        @Override
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            int prev1 = 1;
            int prev2 = 2;
            int result = 0;
            for (int i = 3; i <= n; i++) {
                result = prev1 + prev2;
                prev1 = prev2;
                prev2 = result;
            }
            return result;
        }
    }
}
