package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 344. Reverse String
 *
 * @link https://leetcode.com/problems/reverse-string/
 * @author zhanglei
 * @date 2022/2/25
 */
class P0344 {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }

    @Test
    void test1() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        assertEquals("[o, l, l, e, h]", Arrays.toString(s));
    }

    @Test
    void test2() {
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        assertEquals("[h, a, n, n, a, H]", Arrays.toString(s));
    }
}
