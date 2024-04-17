package leetcode.problems.p08;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * 860. Lemonade Change
 *
 * @link https://leetcode.com/problems/lemonade-change/
 * @author zhanglei
 * @date 2022/5/14
 */
class P0860 {
    public boolean lemonadeChange(int[] bills) {
        // 5, 10, 20
        int[] m = new int[3];
        for (int bill : bills) {
            if (bill == 5) {
                m[0]++;
            } else if (bill == 10) {
                m[1]++;
                m[0]--;
                if (m[0] < 0) {
                    return false;
                }
            } else if (bill == 20) {
                m[2]++;
                if (m[1] > 0) {
                    m[1]--;
                    m[0]--;
                    if (m[0] < 0) {
                        return false;
                    }
                } else {
                    m[0] -= 3;
                    if (m[0] < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Test
    void test1() {
        int[] bills = {5, 5, 5, 10, 20};
        assertTrue(lemonadeChange(bills));
    }

    @Test
    void test2() {
        int[] bills = {5, 5, 10, 10, 20};
        assertFalse(lemonadeChange(bills));
    }
}
