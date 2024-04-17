package leetcode.problems.p01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 134. Gas Station
 *
 * @link https://leetcode.com/problems/gas-station/
 * @author zhanglei
 * @date 2022/4/27
 */
class P0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] temp = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            temp[i] = gas[i] - cost[i];
        }
        int start = 0;
        for (int i = start, tank = 0; i - start < temp.length; i++) {
            tank += temp[i % temp.length];
            if (tank < 0) {
                start = i + 1;
                if (start >= temp.length) {
                    return -1;
                }
                tank = 0;
                i = start - 1;
            }
        }
        return start;
    }

    @Test
    void test1() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        assertEquals(3, canCompleteCircuit(gas, cost));
    }

    @Test
    void test2() {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        assertEquals(-1, canCompleteCircuit(gas, cost));
    }

    @Test
    void test3() {
        int[] gas = {4, 5, 2, 6, 5, 3};
        int[] cost = {3, 2, 7, 3, 2, 9};
        assertEquals(-1, canCompleteCircuit(gas, cost));
    }
}
