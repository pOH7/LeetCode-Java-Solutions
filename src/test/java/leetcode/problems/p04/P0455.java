package leetcode.problems.p04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 *
 * @link https://leetcode.com/problems/assign-cookies/
 * @author zhanglei
 * @date 2022/4/25
 */
class P0455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int i = 0;
        for (int g0 : g) {
            while (i < s.length && g0 > s[i]) {
                i++;
            }
            if (i == s.length) {
                return result;
            }
            if (g0 <= s[i]) {
                result++;
                i++;
            }
        }
        return result;
    }

    @Test
    void test1() {
        int[] g = {1, 2, 3}, s = {1, 1};
        assertEquals(1, findContentChildren(g, s));
    }

    @Test
    void test2() {
        int[] g = {1, 2}, s = {1, 2, 3};
        assertEquals(2, findContentChildren(g, s));
    }
}
