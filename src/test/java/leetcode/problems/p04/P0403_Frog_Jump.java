package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import leetcode.difficulty.Hard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhanglei
 * @version 2024/11/18
 */
@Hard
public class P0403_Frog_Jump {
    @Test
    void test1() {
        Solution solution = new Solution1();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        assertTrue(solution.canCross(stones));
    }

    @Test
    void test2() {
        Solution solution = new Solution1();
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        assertFalse(solution.canCross(stones));
    }

    @Test
    void test52() {
        Solution solution = new Solution1();
        int[] stones = {0, 2};
        assertFalse(solution.canCross(stones));
    }

    interface Solution {
        public boolean canCross(int[] stones);
    }

    // 47 ms Beats 49.91%
    class Solution1 implements Solution {
        @Override
        public boolean canCross(int[] stones) {
            Map<Integer, Set<Integer>> stoneJumps = new HashMap<>();
            for (int i = 0; i < stones.length; i++) {
                stoneJumps.put(stones[i], new HashSet<>());
            }
            stoneJumps.get(stones[0]).add(0);
            for (int i = 0; i < stones.length; i++) {
                // if the stone is reachable, iterator each jumping possibility
                for (int jump : stoneJumps.get(stones[i])) {
                    // the next jump must be jump-1, jump, jump+1, and forward (>0)
                    for (int j = Math.max(1, jump - 1); j <= jump + 1; j++) {
                        // we find a stone to land
                        if (stoneJumps.containsKey(stones[i] + j)) {
                            // it is the last stone
                            if (stones[i] + j == stones[stones.length - 1]) {
                                return true;
                            }
                            stoneJumps.get(stones[i] + j).add(j);
                        }
                    }
                }
            }

            return false;
        }
    }
}
