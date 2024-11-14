package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhanglei
 * @version 2024/11/14
 */
public class P0338_Counting_Bits {
    @Test
    void test1() {
        Solution solution = new Solution2();
        assertEquals("[0,1,1]", Arrays.toString(solution.countBits(2)).replace(" ", ""));
    }

    @Test
    void test2() {
        Solution solution = new Solution2();
        assertEquals("[0,1,1,2,1,2]", Arrays.toString(solution.countBits(5)).replace(" ", ""));
    }

    interface Solution {
        public int[] countBits(int n);
    }

    class Solution1 implements Solution {

        @Override
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 0) {
                    // even
                    ans[i] = ans[i >> 1];
                } else {
                    // odd
                    ans[i] = ans[i - 1] + 1;
                    // i - 1 is even
                    // so ans[i-1] == ans[i >> 1]
                }
            }
            return ans;
        }
    }

    class Solution2 implements Solution {

        @Override
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i >> 1] + (i & 1);
            }
            return ans;
        }
    }
}
