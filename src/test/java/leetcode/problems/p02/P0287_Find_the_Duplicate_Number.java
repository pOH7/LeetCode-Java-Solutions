package leetcode.problems.p02;

import leetcode.difficulty.Medium;
import org.junit.jupiter.api.Test;

/**
 * @author zhanglei
 * @version 2024/11/22
 */
@Medium
public class P0287_Find_the_Duplicate_Number {
    @Test
    void test1() {
        Solution solution = new Solution1();
    }

    interface Solution {
        public int findDuplicate(int[] nums);
    }

    class Solution1 implements Solution {
        @Override
        public int findDuplicate(int[] nums) {
            return 0;
        }
    }
}
